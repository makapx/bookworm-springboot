package bookmanager.app.bookworm.controllers;

// repositories and model import
import bookmanager.app.bookworm.data.AuthorRepository;
import bookmanager.app.bookworm.data.GenreRepository;
import bookmanager.app.bookworm.data.BookRepository;
import bookmanager.app.bookworm.models.Book;

// Spring imports
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * BookController
 * 
 * This class is the controller for the Book model.
 * It handles the HTTP requests
 * 
 * Implements the following routes:
 * GET /book list all books
 * GET /book/add show form to add a book
 * POST /book add a book
 * 
 */
@Controller
@RequestMapping("/book")
public class BookController {
    // Inject the repositories.
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    /**
     * BookController
     * 
     * @param bookRepository book repository
     * @param authorRepository author repository
     * @param genreRepository genre repository
     */
    public BookController(BookRepository bookRepository, AuthorRepository authorRepository, GenreRepository genreRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }

    /**
     * allBooks - list all books
     * request: GET /book
     * response: ThymeLeaf template book.html
     * 
     * @param model
     * @return
     */
    @GetMapping
    public String allBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "book";
    }

    /**
     * bookForm - show form to add a book
     * request: GET /book/add
     * response: ThymeLeaf template addBook.html
     * 
     * @param model
     * @return
     */
    @GetMapping("/add")
    public String bookForm(Model model) {
        model.addAttribute("book", new Book());

        // get all the authors and genres
        // used to populate the select boxes in the form
        model.addAttribute("authors", authorRepository.findAll());
        model.addAttribute("genres", genreRepository.findAll());
        return "addBook";
    }

    /**
     * processBook - add a book
     * request: POST /book
     * response: redirect to /book
     * 
     * @param book book object
     * @return
     */
    @PostMapping
    public String processBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/book";
    }
}
