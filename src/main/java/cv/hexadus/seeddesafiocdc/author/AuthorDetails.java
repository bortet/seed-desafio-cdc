package cv.hexadus.seeddesafiocdc.author;

public class AuthorDetails {
    private final String name;
    private final String email;
    private final String description;

    public AuthorDetails(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public static AuthorDetails getAuthorDetails(Author author){
        return new AuthorDetails(author.getName(), author.getEmail(), author.getDescription());
    }
}
