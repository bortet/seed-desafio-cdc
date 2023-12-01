package cv.hexadus.seeddesafiocdc.author;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidatorImpl implements ConstraintValidator<UniqueEmailValidator, String> {


    private final AuthorRepository authorRepository;

    public UniqueEmailValidatorImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void initialize(UniqueEmailValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean valid = true;
        context.disableDefaultConstraintViolation();
        if (authorRepository.findByEmail(value).isPresent()) {
            context.buildConstraintViolationWithTemplate("Email not available.").addConstraintViolation();
            valid = false;
        }
        return valid;
    }

}
