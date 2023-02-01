package bookmanager.app.bookworm.controllers;

import bookmanager.app.bookworm.data.AuthorRepository;
import bookmanager.app.bookworm.models.Author;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/author")
public class AuthorController {
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public String allAuthors(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "author"; // Invoke ThymeLeaf template
    }

    @GetMapping("/add")
    public String authorForm(Model model) {
        model.addAttribute("author", new Author());
        return "addAuthor"; // Invoke ThymeLeaf template
    }

    @PostMapping
    public String saveAuthor(@ModelAttribute Author author) {
        authorRepository.save(author);
        return "redirect:/author";
    }
    
}
