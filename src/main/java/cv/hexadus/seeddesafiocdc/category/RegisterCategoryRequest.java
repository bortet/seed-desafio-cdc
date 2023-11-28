package cv.hexadus.seeddesafiocdc.category;

import javax.validation.constraints.NotBlank;

public class RegisterCategoryRequest {

    @NotBlank(message = "name cannot be null.")
    @UniqueCategoryValidator
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
