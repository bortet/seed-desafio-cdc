package cv.hexadus.seeddesafiocdc.country;

import cv.hexadus.seeddesafiocdc.exception.RecordNotFoundException;
import cv.hexadus.seeddesafiocdc.util.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/state")
public class StateController {

    private final EntityManager entityManager;

    public StateController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Transactional
    @PostMapping
    public ResponseEntity<APIResponse> registerState(@Valid @RequestBody StateRegistrationRequest request) {
        State stateModal = request.getStateModal(entityManager);
        entityManager.persist(stateModal);
        APIResponse apiResponse = APIResponse.Builder.newBuilder()
                .status(true)
                .statusText(HttpStatus.CREATED.name())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }
}
