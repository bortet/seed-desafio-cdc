package cv.hexadus.seeddesafiocdc.book;

public class BookInformation {

    private final long id;
    private final String title;
    private final String summary;
    private final String sinopsys;

    public BookInformation(long id, String title, String summary, String sinopsys) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.sinopsys = sinopsys;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getSinopsys() {
        return sinopsys;
    }

    public static BookInformation getBookInformation(Book book) {
        return new BookInformation(book.getId(), book.getTitle(), book.getSummary(), book.getSinopsys());
    }
}
