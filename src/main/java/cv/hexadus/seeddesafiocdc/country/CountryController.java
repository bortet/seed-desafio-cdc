package cv.hexadus.seeddesafiocdc.country;

import cv.hexadus.seeddesafiocdc.exception.RecordNotFoundException;
import cv.hexadus.seeddesafiocdc.util.APIResponse;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/country")
public class CountryController {

    @PersistenceContext
    private final EntityManager entityManager;

    public CountryController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Transactional
    @PostMapping
    public ResponseEntity<APIResponse> register(@Valid @RequestBody CountryRegistrationRequest request) {

        Country countryModal = request.getCountryModal();
        List<State> stateModal = request.getStateModal();
        if (!stateModal.isEmpty()) {
            stateModal.forEach(currentState -> currentState.setCountry(countryModal));
        }
        entityManager.persist(countryModal);
        if (!stateModal.isEmpty()) {
            stateModal.forEach(currentState -> entityManager.persist(currentState));
        }
        APIResponse apiResponse = APIResponse.Builder.newBuilder()
                .status(true)
                .statusText(HttpStatus.CREATED.name())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }
}
