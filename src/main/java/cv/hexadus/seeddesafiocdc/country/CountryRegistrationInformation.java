package cv.hexadus.seeddesafiocdc.country;

import cv.hexadus.seeddesafiocdc.validator.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CountryRegistrationInformation {

    @NotBlank(message = "name is required.")
    @UniqueValue(domainClass = Country.class, fieldName = "name")
    private final String name;
    @NotBlank(message = "code 1 is required.")
    @UniqueValue(domainClass = Country.class, fieldName = "code1")
    private final String code1;
    @NotBlank(message = "code 2 is required.")
    @UniqueValue(domainClass = Country.class, fieldName = "code2")
    private final String code2;
    @NotBlank(message = "code 3 is required.")
    @UniqueValue(domainClass = Country.class, fieldName = "code3")
    private final String code3;

    public CountryRegistrationInformation(String name, String code1, String code2, String code3) {
        this.name = name;
        this.code1 = code1;
        this.code2 = code2;
        this.code3 = code3;
    }

    public String getName() {
        return name;
    }

    public String getCode1() {
        return code1;
    }

    public String getCode2() {
        return code2;
    }

    public String getCode3() {
        return code3;
    }
}
