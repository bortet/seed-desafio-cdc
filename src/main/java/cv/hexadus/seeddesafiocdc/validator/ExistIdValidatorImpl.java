package cv.hexadus.seeddesafiocdc.validator;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistIdValidatorImpl implements ConstraintValidator<ExistId, Long> {

    private final EntityManager entityManager;
    private String domainId;
    private Class<?> aClass;

    public ExistIdValidatorImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void initialize(ExistId param) {
        this.domainId = param.fieldName();
        this.aClass = param.domainClass();
        ConstraintValidator.super.initialize(param);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery("SELECT 1 FROM " + this.aClass.getName() + " WHERE " + this.domainId + "=:value");
        query.setParameter("value", value);
        List<?> resultList = query.getResultList();
        if(resultList.isEmpty())
            return false;
        return true;
    }
}
