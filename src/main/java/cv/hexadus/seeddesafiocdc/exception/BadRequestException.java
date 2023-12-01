package cv.hexadus.seeddesafiocdc.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message){
        super(message);
    }
}
