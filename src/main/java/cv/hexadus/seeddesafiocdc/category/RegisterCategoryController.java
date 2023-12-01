package cv.hexadus.seeddesafiocdc.category;

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

@RestController
@RequestMapping("api/v1/category")
public class RegisterCategoryController {

    @PersistenceContext
    private final EntityManager manager;

    public RegisterCategoryController(EntityManager manager) {
        this.manager = manager;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<APIResponse> registerCategory(@Valid @RequestBody RegisterCategoryRequest request){

        Category category = request.mapToModal();
        manager.persist(category);

        APIResponse response = APIResponse.Builder.newBuilder()
                .status(true)
                .statusText(HttpStatus.OK.name())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
