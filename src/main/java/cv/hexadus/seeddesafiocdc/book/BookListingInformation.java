package cv.hexadus.seeddesafiocdc.book;

public class BookListingInformation {
    private final long id;
    private final String title;

    public BookListingInformation(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public static BookListingInformation getBookInformation(Book book){
        return new BookListingInformation(book.getId(), book.getTitle());
    }
}
