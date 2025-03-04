package cv.hexadus.seeddesafiocdc.exception;

import cv.hexadus.seeddesafiocdc.util.APIResponse;
import cv.hexadus.seeddesafiocdc.util.ErrorResponse;
import cv.hexadus.seeddesafiocdc.util.ResponseDetail;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Error> collect = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(currentError -> new Error(currentError.getField(), currentError.getDefaultMessage()))
                .collect(Collectors.toList());

        ResponseDetail responseDetail = ResponseDetail.Builder.newBuilder()
                .error(ErrorResponse.Builder.newBuilder()
                        .errors(collect)
                        .numberOfErrors(collect.size())
                        .build())
                .build();

        APIResponse error = APIResponse.Builder.newBuilder()
                .status(false)
                .statusText(HttpStatus.BAD_REQUEST.name())
                .details(responseDetail)
                .build();
        return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConflictException.class)
    public final ResponseEntity<Object> handleConflictException(Exception ex, WebRequest request) {

        String message = ex.getMessage();
        ResponseDetail responseDetail = ResponseDetail.Builder.newBuilder()
                .error(ErrorResponse.Builder.newBuilder()
                        .globalError(List.of(message))
                        .numberOfErrors(1)
                        .build())
                .build();

        APIResponse error = APIResponse.Builder.newBuilder()
                .status(false)
                .statusText(HttpStatus.CONFLICT.name())
                .details(responseDetail)
                .build();
        return new ResponseEntity<Object>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<Object> handleRecordNotFound(Exception ex, WebRequest request) {

        String message = ex.getMessage();
        ResponseDetail responseDetail = ResponseDetail.Builder.newBuilder()
                .error(ErrorResponse.Builder.newBuilder()
                        .globalError(List.of(message))
                        .numberOfErrors(1)
                        .build())
                .build();

        APIResponse error = APIResponse.Builder.newBuilder()
                .status(true)
                .statusText(HttpStatus.NOT_FOUND.name())
                .details(responseDetail)
                .build();

        return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<Object> handleBadRequest(Exception ex, WebRequest request) {
        String message = ex.getMessage();
        ResponseDetail responseDetail = ResponseDetail.Builder.newBuilder()
                .error(ErrorResponse.Builder.newBuilder()
                        .globalError(List.of(message))
                        .numberOfErrors(1)
                        .build())
                .build();
        APIResponse error = APIResponse.Builder.newBuilder()
                .statusText(HttpStatus.BAD_REQUEST.name())
                .details(responseDetail)
                .build();

        return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalStateException.class)
    public final ResponseEntity<Object> unhandledIllegalStateException(IllegalStateException ex, WebRequest request) {

        logger.error(ex.getLocalizedMessage());
        String message = ex.getMessage();
        String localizedMessage = ex.getLocalizedMessage();
        Error error = new Error(localizedMessage, message);
        ResponseDetail responseDetail = ResponseDetail.Builder.newBuilder()
                .error(ErrorResponse.Builder.newBuilder().errors(List.of(error)).build())
                .build();
        APIResponse response = APIResponse.Builder.newBuilder()
                .status(false)
                .statusText(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .details(responseDetail)
                .build();

        return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> unhandledException(Exception ex, WebRequest request) {

        logger.error(ex.getLocalizedMessage());
        Error error = new Error(ex.getCause().getMessage(), ex.getLocalizedMessage());
        ResponseDetail responseDetail = ResponseDetail.Builder.newBuilder()
                .error(ErrorResponse.Builder.newBuilder().errors(List.of(error)).build())
                .build();
        APIResponse response = APIResponse.Builder.newBuilder()
                .status(false)
                .statusText(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .details(responseDetail)
                .build();

        return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
