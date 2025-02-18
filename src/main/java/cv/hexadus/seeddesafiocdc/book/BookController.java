package cv.hexadus.seeddesafiocdc.book;

import cv.hexadus.seeddesafiocdc.exception.RecordNotFoundException;
import cv.hexadus.seeddesafiocdc.util.APIResponse;
import cv.hexadus.seeddesafiocdc.util.ResponseDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/book")
public class BookController {

    @PersistenceContext
    private final EntityManager entityManager;

    public BookController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<APIResponse> register(@Valid @RequestBody RegisterBookRequest request) {
        Book newBook = request.toModal(entityManager);
        entityManager.persist(newBook);
        APIResponse response = APIResponse.Builder.newBuilder()
                .status(true)
                .statusText(HttpStatus.OK.name())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("list")
    public ResponseEntity<APIResponse> getBookList(@RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
                                                   @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Query query = entityManager.createQuery("SELECT b FROM Book b", Book.class);
        query.setFirstResult((pageNumber) * pageSize);
        query.setMaxResults(pageSize);
        Object collect = query.getResultList()
                .stream()
                .map(currentBook -> BookListingInformation.getBookInformation((Book) currentBook))
                .collect(Collectors.toList());

        APIResponse response = APIResponse.Builder.newBuilder()
                .status(true)
                .statusText(HttpStatus.OK.name())
                .details(ResponseDetail.Builder.newBuilder().details((List<Object>) collect).build())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);

    }


    @GetMapping()
    public ResponseEntity<APIResponse> getDetail(@RequestParam(value = "id") String id) {
        Book book = entityManager.find(Book.class, Long.parseLong(id));
        if (book == null) {
            throw new RecordNotFoundException("Book with id: " + id + " was not found");
        }
        APIResponse response = APIResponse.Builder.newBuilder()
                .statusText(HttpStatus.OK.name())
                .status(true)
                .details(ResponseDetail
                        .Builder.newBuilder()
                        .details(Collections.singletonList(BookDetail.getBookDetail(book)))
                        .build())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
