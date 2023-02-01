package bookmanager.app.bookworm.controllers;

// import repository and model
import bookmanager.app.bookworm.data.GenreRepository;
import bookmanager.app.bookworm.models.Genre;

// import Spring annotations
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * GenreController
 * 
 * This class is the controller for the Genre model.
 * It handles the HTTP requests
 * 
 * Implements the following routes:
 * GET /genre list all genres
 * GET /genre/add show form to add a genre
 * POST /genre add a genre
 * 
 */
@Controller
@RequestMapping("/genre")
public class GenreController {
    // Inject the repository.
    private final GenreRepository genreRepository;

    /**
     * GenreController
     * 
     * @param genreRepository genre repository
     */
    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    /**
     * allGenres - list all genres
     * request: GET /genre
     * response: ThymeLeaf template genre.html
     * 
     * @param model
     * @return
     */
    @GetMapping
    public String allGenres(Model model) {
        model.addAttribute("genres", genreRepository.findAll());
        return "genre";
    }

    /**
     * genreForm - show form to add a genre
     * request: GET /genre/add
     * response: ThymeLeaf template addGenre.html
     * 
     * @param model
     * @return
     */
    @GetMapping("/add")
    public String genreForm(Model model) {
        model.addAttribute("genre", new Genre());
        return "addGenre";
    }

    /**
     * saveGenre - add a genre
     * request: POST /genre
     * response: redirect to /genre
     * 
     * @param genre
     * @return
     */
    @PostMapping
    public String saveGenre(@ModelAttribute Genre genre) {
        genreRepository.save(genre);
        return "redirect:/genre";
    }
}
