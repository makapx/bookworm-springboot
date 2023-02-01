package bookmanager.app.bookworm.controllers;

// repositories and model import
import bookmanager.app.bookworm.data.AuthorRepository;
import bookmanager.app.bookworm.models.Author;

// Spring import
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * AuthorController
 * 
 * This class is the controller for the Author model.
 * It handles the HTTP requests
 * 
 * Implements the following routes:
 * GET /author list all authors
 * GET /author/add show form to add an author
 * POST /author add an author
 * 
 */
@Controller
@RequestMapping("/author")
public class AuthorController {
    // Inject the repository.
    private final AuthorRepository authorRepository;

    /**
     * AuthorController
     * 
     * @param authorRepository author repository
     */
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    /**
     * allAuthors - list all authors
     * request: GET /author
     * response: ThymeLeaf template author.html
     * 
     * @param model
     * @return
     */
    @GetMapping
    public String allAuthors(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "author"; // Invoke ThymeLeaf template
    }

    /**
     * authorForm - show form to add an author
     * request: GET /author/add
     * response: ThymeLeaf template addAuthor.html
     * 
     * @param model
     * @return
     */
    @GetMapping("/add")
    public String authorForm(Model model) {
        model.addAttribute("author", new Author());
        return "addAuthor"; // Invoke ThymeLeaf template
    }

    /**
     * saveAuthor - add an author
     * request: POST /author
     * response: redirect to /author
     * 
     * @param author
     * @return
     */
    @PostMapping
    public String saveAuthor(@ModelAttribute Author author) {
        authorRepository.save(author);
        return "redirect:/author";
    } 
}
