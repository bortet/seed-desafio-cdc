package cv.hexadus.seeddesafiocdc.book;

import cv.hexadus.seeddesafiocdc.author.Author;
import cv.hexadus.seeddesafiocdc.category.Category;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String summary;
    private String sinopsys;
    private double price;
    private int totalPageNumber;
    private String isbn;
    private LocalDate publishDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "category_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "category_id_fk")
    )
    private Category category;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "author_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "author_id_fk")
    )
    private Author author;

    public Book() {
    }

    public Book(String title, String summary, String sinopsys, double price, int totalPageNumber, String isbn, LocalDate publishDate, Category category, Author author) {
        this.title = title;
        this.summary = summary;
        this.sinopsys = sinopsys;
        this.price = price;
        this.totalPageNumber = totalPageNumber;
        this.isbn = isbn;
        this.publishDate = publishDate;
        this.category = category;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSinopsys() {
        return sinopsys;
    }

    public void setSinopsys(String sinopsys) {
        this.sinopsys = sinopsys;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTotalPageNumber() {
        return totalPageNumber;
    }

    public void setTotalPageNumber(int totalPageNumber) {
        this.totalPageNumber = totalPageNumber;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
