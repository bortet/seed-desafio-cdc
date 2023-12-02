package cv.hexadus.seeddesafiocdc.checkout;

import javax.validation.constraints.NotBlank;

public class CustomerPersonalInformation {

    @NotBlank(message = "required field.")
    private final String name;
    @NotBlank(message = "required field.")
    private final String surname;


    public CustomerPersonalInformation(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

}
