package cv.hexadus.seeddesafiocdc.author;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/author")
public class RegisterAuthorController {

    private final AuthorRepository repository;
    @PersistenceContext
    private EntityManager manager;
    /*private final AuthorUniqueEmailValidator authorUniqueEmailValidator;*/

    public RegisterAuthorController(AuthorRepository repository) {
        this.repository = repository;
     /*   this.authorUniqueEmailValidator = authorUniqueEmailValidator;*/
    }
/*
    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(authorUniqueEmailValidator);
    }*/

    @Transactional
    @PostMapping
    public ResponseEntity<Object> registerAuthor(@RequestBody @Valid RegisterAuthorRequest request) {
        Author author = request.toModel();
        manager.persist(author);

        AuthorInfo authorInfo = AuthorInfo.toDto(author);
        return new ResponseEntity<>(authorInfo, HttpStatus.OK);
    }

}
