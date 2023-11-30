package cv.hexadus.seeddesafiocdc.category;

import cv.hexadus.seeddesafiocdc.validator.UniqueValue;

import javax.validation.constraints.NotBlank;

public class RegisterCategoryRequest {

    @NotBlank(message = "name cannot be null.")
    @UniqueValue(domainClass = Category.class, fieldName = "name")
    private String name;

    public RegisterCategoryRequest() {
    }

    public RegisterCategoryRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Category mapToModal(){
        return new Category(this.name);
    }
}
