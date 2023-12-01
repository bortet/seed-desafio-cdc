package cv.hexadus.seeddesafiocdc.book;

import cv.hexadus.seeddesafiocdc.util.Pagination;

import java.util.List;

public class BookInformationList {

    private final List<BookInformation> bookInformationList;
    private final Pagination pagination;

    public BookInformationList(List<BookInformation> bookInformationList, Pagination pagination) {
        this.bookInformationList = bookInformationList;
        this.pagination = pagination;
    }

    public List<BookInformation> getBookInformationList() {
        return bookInformationList;
    }

    public Pagination getPagination() {
        return pagination;
    }
}
