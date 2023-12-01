package cv.hexadus.seeddesafiocdc.book;

public class BookInformation {
    private long id;
    private String title;

    public BookInformation(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public static BookInformation getBookInformation(Book book){
        return new BookInformation(book.getId(), book.getTitle());
    }
}
