package cv.hexadus.seeddesafiocdc.checkout;

import cv.hexadus.seeddesafiocdc.country.Country;
import cv.hexadus.seeddesafiocdc.validator.ExistId;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CustomerAddress {

    @ExistId(domainClass = Country.class, fieldName = "id")
    @NotNull(message = "required field.")
    private final long countryCode;
    @NotBlank(message = "required field.")
    private final String city;
    private final long stateCode;
    @NotBlank(message = "required field.")
    private final String cep;
    @NotBlank(message = "required field.")
    private final String neighborhood;
    @NotBlank(message = "required field.")
    private final String complement;

    public CustomerAddress(long countryCode, String city, long stateCode, String cep, String neighborhood, String complement) {
        this.countryCode = countryCode;
        this.city = city;
        this.stateCode = stateCode;
        this.cep = cep;
        this.neighborhood = neighborhood;
        this.complement = complement;
    }

    public long getCountryCode() {
        return countryCode;
    }

    public String getCity() {
        return city;
    }

    public long getStateCode() {
        return stateCode;
    }

    public String getCep() {
        return cep;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getComplement() {
        return complement;
    }
}
