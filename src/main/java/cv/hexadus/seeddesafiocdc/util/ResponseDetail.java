package cv.hexadus.seeddesafiocdc.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import cv.hexadus.seeddesafiocdc.exception.Error;

import java.util.List;

public class ResponseDetail {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Object> details;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final ErrorResponse error;

    private ResponseDetail(Builder builder) {
        details = builder.details;
        error = builder.error;
    }

    public List<Object> getDetails() {
        return details;
    }

    public ErrorResponse getError() {
        return error;
    }

    public static final class Builder {
        private List<Object> details;
        private ErrorResponse error;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder details(List<Object> val) {
            details = val;
            return this;
        }

        public Builder error(ErrorResponse val) {
            error = val;
            return this;
        }

        public ResponseDetail build() {
            return new ResponseDetail(this);
        }
    }
}
