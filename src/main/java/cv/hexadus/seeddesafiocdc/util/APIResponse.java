package cv.hexadus.seeddesafiocdc.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

public class APIResponse {

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private final LocalDateTime timestamp = LocalDateTime.now();
    private final boolean status;
    private final String statusText;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final ResponseDetail data;

    private APIResponse(Builder builder) {
        status = builder.status;
        statusText = builder.statusText;
        data = builder.details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public boolean isStatus() {
        return status;
    }

    public String getStatusText() {
        return statusText;
    }

    public ResponseDetail getData() {
        return data;
    }

    public static final class Builder {
        private boolean status;
        private String statusText;
        private ResponseDetail details;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder status(boolean val) {
            status = val;
            return this;
        }

        public Builder statusText(String val) {
            statusText = val;
            return this;
        }

        public Builder details(ResponseDetail val) {
            details = val;
            return this;
        }

        public APIResponse build() {
            return new APIResponse(this);
        }
    }
}
