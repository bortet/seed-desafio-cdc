package cv.hexadus.seeddesafiocdc.author;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AuthorUniqueEmailValidator implements Validator {

    private final AuthorRepository authorRepository;

    public AuthorUniqueEmailValidator(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return RegisterAuthorRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors())
            return;

        RegisterAuthorRequest request = (RegisterAuthorRequest) target;
        if(authorRepository.findByEmail(request.getEmail()).isPresent()){
            errors.rejectValue("email", null, "Email "+ request.getEmail() + " its already registered.");
            /*throw new ConflictException("Email not available.");*/
        }
    }
}
