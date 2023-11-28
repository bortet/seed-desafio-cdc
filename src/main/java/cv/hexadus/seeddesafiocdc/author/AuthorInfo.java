package cv.hexadus.seeddesafiocdc.author;

public class AuthorInfo {
    private String id;
    private String name;
    private String email;
    private String description;

    public AuthorInfo() {
    }

    public AuthorInfo(String id, String name, String email, String description) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public static AuthorInfo toDto(Author author) {
        return new AuthorInfo(author.getId().toString(), author.getName(), author.getEmail(), author.getDescription());
    }

    public String getId() {
        return id;
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
}
