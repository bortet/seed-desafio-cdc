package cv.hexadus.seeddesafiocdc.category;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueCategoryValidatorImpl implements ConstraintValidator<UniqueCategoryValidator, String> {

    private final CategoryRepository categoryRepository;

    public UniqueCategoryValidatorImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initialize(UniqueCategoryValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        Optional<Category> result = categoryRepository.findByName(value);
        if(result.isPresent()){
            context.buildConstraintViolationWithTemplate("Category name: " + value + " its already registered.")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
