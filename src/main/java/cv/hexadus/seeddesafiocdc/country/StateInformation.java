package cv.hexadus.seeddesafiocdc.country;

public class StateInformation {

    private long id;
    private String name;
    private String code;

    public StateInformation(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
