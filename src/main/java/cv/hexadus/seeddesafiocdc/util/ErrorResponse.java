package cv.hexadus.seeddesafiocdc.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import cv.hexadus.seeddesafiocdc.exception.Error;

import java.util.List;

public class ErrorResponse {

    private final List<Error> errors;
    private final List<Object> globalError;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final int numberOfErrors;

    private ErrorResponse(Builder builder) {
        errors = builder.errors;
        globalError = builder.globalError;
        numberOfErrors = builder.numberOfErrors;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public List<Object> getGlobalError() {
        return globalError;
    }

    public int getNumberOfErrors() {
        return numberOfErrors;
    }

    public static final class Builder {
        private List<Error> errors;
        private List<Object> globalError;
        private int numberOfErrors;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder errors(List<Error> val) {
            errors = val;
            return this;
        }

        public Builder globalError(List<Object> val) {
            globalError = val;
            return this;
        }

        public Builder numberOfErrors(int val) {
            numberOfErrors = val;
            return this;
        }

        public ErrorResponse build() {
            return new ErrorResponse(this);
        }
    }
}
