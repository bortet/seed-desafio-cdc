package cv.hexadus.seeddesafiocdc.book;

import cv.hexadus.seeddesafiocdc.author.Author;
import cv.hexadus.seeddesafiocdc.category.Category;
import cv.hexadus.seeddesafiocdc.validator.ExistId;
import cv.hexadus.seeddesafiocdc.validator.UniqueValue;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class RegisterBookRequest {
    @NotBlank(message = "title is required.")
    @UniqueValue(domainClass = Book.class, fieldName = "title")
    private String title;
    private String summary;
    @Size(max = 500)
    @NotBlank(message = "sinopsys is required.")
    private String sinopsys;
    @Min(value = 20)
    @NotNull(message = "price is required.")
    private Double price;
    @Min(value = 100)
    @NotNull(message = "total page is required.")
    private int totalPage;
    @UniqueValue(domainClass = Book.class, fieldName = "isbn")
    @NotBlank(message = "isbn is required.")
    private String isbn;
    @Future(message = "publish date must be in the future.")
    @NotNull(message = "publish date is required.")
    private LocalDate publishdate;
    @NotNull(message = "category code is required.")
    @ExistId(domainClass = Category.class, fieldName = "id")
    private Long categoryCode;
    @NotNull(message = "author code is required.")
    @ExistId(domainClass = Author.class, fieldName = "id")
    private Long authorCode;

    public RegisterBookRequest(String title, String summary, String sinopsys, Double price, int totalPage, String isbn,
                               LocalDate publishdate, Long categoryCode, Long authorCode) {
        this.title = title;
        this.summary = summary;
        this.sinopsys = sinopsys;
        this.price = price;
        this.totalPage = totalPage;
        this.isbn = isbn;
        this.publishdate = publishdate;
        this.categoryCode = categoryCode;
        this.authorCode = authorCode;
    }

    public Long getCategoryCode() {
        return categoryCode;
    }

    public Long getAuthorCode() {
        return authorCode;
    }

    public Book toModal(EntityManager entityManager) {
        Category category = entityManager.find(Category.class, categoryCode);
        Author author = entityManager.find(Author.class, authorCode);

        Assert.state(author != null, "Author with id: " + this.authorCode + " was not found.");
        Assert.state(category != null, "Category with id: " + this.categoryCode + " was not found.");
        return new Book(title, summary, sinopsys, price, totalPage, isbn, publishdate, category, author);
    }
}
