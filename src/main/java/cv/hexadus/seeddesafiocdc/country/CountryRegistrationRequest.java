package cv.hexadus.seeddesafiocdc.country;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CountryRegistrationRequest {

    @Valid
    @NotNull(message = "field cannot be null.")
    private final CountryRegistrationInformation countryRegistrationInformation;
    @Valid
    private final List<StateRegistrationInformation> stateRegistrationInformation;

    public CountryRegistrationRequest(CountryRegistrationInformation countryRegistrationInformation, List<StateRegistrationInformation> stateRegistrationInformation) {
        this.countryRegistrationInformation = countryRegistrationInformation;
        this.stateRegistrationInformation = stateRegistrationInformation;
    }

    public CountryRegistrationInformation getCountryRegistrationInformation() {
        return countryRegistrationInformation;
    }

    public List<StateRegistrationInformation> getStateRegistrationInformation() {
        return stateRegistrationInformation;
    }

    public Country getCountryModal(){
        return new Country(countryRegistrationInformation.getCode1(), countryRegistrationInformation.getCode2(),
                countryRegistrationInformation.getCode3(), countryRegistrationInformation.getName());
    }

    public List<State> getStateModal(){
        if(this.stateRegistrationInformation != null){
            return this.stateRegistrationInformation.
                    stream().map(currentState -> currentState.getModal())
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
