package bookmanager.app.bookworm.controllers;

import bookmanager.app.bookworm.data.BookRepository;
import bookmanager.app.bookworm.models.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public String bookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book"; // Invoke ThymeLeaf template
    }

    @PostMapping
    public String processBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/book";
    }

}
