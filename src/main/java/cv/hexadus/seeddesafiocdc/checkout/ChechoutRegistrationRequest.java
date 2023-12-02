package cv.hexadus.seeddesafiocdc.checkout;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ChechoutRegistrationRequest {

    @Valid
    @NotNull(message = "Customer Personal Information cannot be null.")
    private final CustomerPersonalInformation customerPersonalInformation;
    @Valid
    @NotNull(message = "Customer Document cannot be null.")
    private final CustomerDocument customerDocument;
    @Valid
    @NotNull(message = "Customer Contact cannot be null.")
    private final CustomerContact customerContact;
    @Valid
    @NotNull(message = "Customer Address cannot be null.")
    private final CustomerAddress customerAddress;


    public ChechoutRegistrationRequest(CustomerPersonalInformation customerPersonalInformation, CustomerDocument customerDocument,
                                       CustomerContact customerContact, CustomerAddress customerAddress) {
        this.customerPersonalInformation = customerPersonalInformation;
        this.customerDocument = customerDocument;
        this.customerContact = customerContact;
        this.customerAddress = customerAddress;
    }

    public CustomerPersonalInformation getCustomerPersonalInformation() {
        return customerPersonalInformation;
    }

    public CustomerContact getCustomerContact() {
        return customerContact;
    }

    public CustomerAddress getCustomerAddress() {
        return customerAddress;
    }

    public CustomerDocument getCustomerDocument() {
        return customerDocument;
    }
}
