package cv.hexadus.seeddesafiocdc.exception;

import javax.validation.ConstraintDeclarationException;

public class RecordNotFoundException extends ConstraintDeclarationException {

    public RecordNotFoundException(String message) {
        super(message);
    }
}
