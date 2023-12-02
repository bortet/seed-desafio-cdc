package cv.hexadus.seeddesafiocdc.checkout;

import cv.hexadus.seeddesafiocdc.util.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/checkout")
public class CheckoutController {


    @PostMapping
    public ResponseEntity<APIResponse> register(@Valid @RequestBody ChechoutRegistrationRequest request){

        APIResponse response = APIResponse.Builder.newBuilder()
                .status(true)
                .statusText(HttpStatus.CREATED.name())
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
