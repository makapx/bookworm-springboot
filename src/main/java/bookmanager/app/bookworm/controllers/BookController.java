package bookmanager.app.bookworm.controllers;

import bookmanager.app.bookworm.data.BookRepository;
import bookmanager.app.bookworm.models.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import bookmanager.app.bookworm.data.AuthorRepository;
import bookmanager.app.bookworm.data.GenreRepository;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    public BookController(BookRepository bookRepository,
        AuthorRepository authorRepository, GenreRepository genreRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }

    @GetMapping
    public String allBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "book"; // Invoke ThymeLeaf template
    }

    @GetMapping("/add")
    public String bookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorRepository.findAll());
        model.addAttribute("genres", genreRepository.findAll());
        return "addBook"; // Invoke ThymeLeaf template
    }

    @PostMapping
    public String processBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/book";
    }

}
