package cv.hexadus.seeddesafiocdc.checkout;

import javax.validation.constraints.NotBlank;

public class CustomerDocument {

    @NotBlank(message = "cannot be empty")
    private final String type;
    @NotBlank(message = "cannot be empty")
    private final String id;

    public CustomerDocument(String type, String id) {
        this.type = type;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }
}
