package cv.hexadus.seeddesafiocdc.country;

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
@RequestMapping("api/v1/state")
public class StateController {

    @PersistenceContext
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

    @GetMapping("country")
    public ResponseEntity<APIResponse> getStatesByCountryId(@RequestParam(name = "id") long id) {
        Query query = entityManager.createQuery("SELECT s FROM State s WHERE country.id =:id");

        query.setParameter("id", id);
        List<State> resultList = query.getResultList();
        List<StateInformation> states = resultList.stream()
                .map(currentState -> new StateInformation(currentState.getName(), currentState.getCode()))
                .collect(Collectors.toList());

        APIResponse apiResponse = APIResponse.Builder.newBuilder()
                .status(true)
                .statusText(HttpStatus.OK.name())
                .details(ResponseDetail.Builder.newBuilder().details(Collections.singletonList(states)).build())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
