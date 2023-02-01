package bookmanager.app.bookworm.controllers;

import bookmanager.app.bookworm.data.BookRepository;
import bookmanager.app.bookworm.models.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import bookmanager.app.bookworm.data.AuthorRepository;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public String bookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorRepository.findAll());
        return "book"; // Invoke ThymeLeaf template
    }

    @PostMapping
    public String processBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/book";
    }

}
