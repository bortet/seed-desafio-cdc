package cv.hexadus.seeddesafiocdc.book;

import cv.hexadus.seeddesafiocdc.author.Author;
import cv.hexadus.seeddesafiocdc.author.AuthorDetails;

public class BookDetail {

    private final AuthorDetails author;
    private final BookInformation bookInformation;
    private final ProductInformation productInformation;

    public BookDetail(AuthorDetails author, BookInformation bookInformation, ProductInformation productInformation) {
        this.author = author;
        this.bookInformation = bookInformation;
        this.productInformation = productInformation;
    }

    public static BookDetail getBookDetail(Book book) {
        Author author = book.getAuthor();
        return new BookDetail(AuthorDetails.getAuthorDetails(author),
                BookInformation.getBookInformation(book), ProductInformation.getProductInformation(book));
    }

    public AuthorDetails getAuthor() {
        return author;
    }

    public BookInformation getBookInformation() {
        return bookInformation;
    }

    public ProductInformation getProductInformation() {
        return productInformation;
    }
}
