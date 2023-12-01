package cv.hexadus.seeddesafiocdc.util;

public class Pagination {

    private final long pageNumber;
    private final long pageSize;
    private final long totalPages;
    private final long totalElements;

    public Pagination(long pageNumber, long pageSize, long totalPages, long totalElements) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }

    public long getPageNumber() {
        return pageNumber;
    }

    public long getPageSize() {
        return pageSize;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }
}
