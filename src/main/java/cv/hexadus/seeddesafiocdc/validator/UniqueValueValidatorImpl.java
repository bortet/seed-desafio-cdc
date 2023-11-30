package cv.hexadus.seeddesafiocdc.validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidatorImpl implements ConstraintValidator<UniqueValue, String> {

    private String domainAttribute;
    private Class<?> aClass;
    @PersistenceContext
    private final EntityManager entityManager;

    public UniqueValueValidatorImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void initialize(UniqueValue params) {
        this.aClass = params.domainClass();
        this.domainAttribute = params.fieldName();
        ConstraintValidator.super.initialize(params);
    }

    @Override
    public boolean isValid(String fieldValue, ConstraintValidatorContext context) {
        boolean isValid = true;

        Query query = entityManager.createQuery("SELECT 1 from " + this.aClass.getName() + " WHERE " + this.domainAttribute + "=:value");
        query.setParameter("value", fieldValue);

        List<?> resultList = query.getResultList();

        if(!resultList.isEmpty())
            isValid = false;
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("value: [" + fieldValue + "], already registered.")
                .addConstraintViolation();

        entityManager.close();
        return isValid;
    }
}
