package cv.hexadus.seeddesafiocdc.category;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueCategoryValidatorImpl.class)
public @interface UniqueCategoryValidator {
    String message() default "Category must be unique.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
