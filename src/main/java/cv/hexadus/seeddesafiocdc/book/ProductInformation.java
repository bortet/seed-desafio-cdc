package cv.hexadus.seeddesafiocdc.book;

import java.time.LocalDate;

public class ProductInformation {
    private final double price;
    private final int totalPageNumber;
    private final String isbn;
    private final LocalDate publishDate;

    public ProductInformation(double price, int totalPageNumber, String isbn, LocalDate publishDate) {
        this.price = price;
        this.totalPageNumber = totalPageNumber;
        this.isbn = isbn;
        this.publishDate = publishDate;
    }

    public static ProductInformation getProductInformation(Book book) {
        return new ProductInformation(book.getPrice(), book.getTotalPageNumber(), book.getIsbn(),
                book.getPublishDate());
    }

    public double getPrice() {
        return price;
    }

    public int getTotalPageNumber() {
        return totalPageNumber;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }
}
