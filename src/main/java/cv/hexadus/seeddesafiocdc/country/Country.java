package cv.hexadus.seeddesafiocdc.country;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code1;
    private String code2;
    private String code3;
    private String name;
    @OneToMany(mappedBy = "country")
    private List<State> state;

    public Country() {
    }

    public Country(String code1, String code2, String code3, String name) {
        this.code1 = code1;
        this.code2 = code2;
        this.code3 = code3;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode1() {
        return code1;
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public String getCode3() {
        return code3;
    }

    public void setCode3(String code3) {
        this.code3 = code3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<State> getState() {
        return state;
    }

    public void setState(List<State> state) {
        this.state = state;
    }

    public void addState(State newState){
        if(this.state == null)
            this.state = new ArrayList<>();
        this.state.add(newState);
    }
}
