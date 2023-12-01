package cv.hexadus.seeddesafiocdc.book;

import cv.hexadus.seeddesafiocdc.util.Pagination;

import java.util.List;

public class BookInformationList {

    private final List<BookListingInformation> bookListingInformationList;
    private final Pagination pagination;

    public BookInformationList(List<BookListingInformation> bookListingInformationList, Pagination pagination) {
        this.bookListingInformationList = bookListingInformationList;
        this.pagination = pagination;
    }

    public List<BookListingInformation> getBookInformationList() {
        return bookListingInformationList;
    }

    public Pagination getPagination() {
        return pagination;
    }
}
