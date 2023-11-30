package cv.hexadus.seeddesafiocdc.book;

import cv.hexadus.seeddesafiocdc.author.Author;
import cv.hexadus.seeddesafiocdc.category.Category;
import cv.hexadus.seeddesafiocdc.category.CategoryRepository;
import cv.hexadus.seeddesafiocdc.exception.RecordNotFoundException;
import cv.hexadus.seeddesafiocdc.util.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/book")
public class BookController {

    @PersistenceContext
    private final EntityManager entityManager;
    private final CategoryRepository categoryRepository;

    public BookController(EntityManager entityManager, CategoryRepository categoryRepository) {
        this.entityManager = entityManager;
        this.categoryRepository = categoryRepository;
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
}
