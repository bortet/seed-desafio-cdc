package cv.hexadus.seeddesafiocdc.checkout;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CustomerContact {

    @Email(message = "value email format is required.")
    @NotNull(message = "cannot be null.")
    private final String email;
    @NotBlank(message = "required field.")
    private final String mobilephone;

    public CustomerContact(String email, String mobilephone) {
        this.email = email;
        this.mobilephone = mobilephone;
    }

    public String getEmail() {
        return email;
    }

    public String getMobilephone() {
        return mobilephone;
    }
}
