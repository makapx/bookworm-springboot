package bookmanager.app.bookworm.controllers;

import bookmanager.app.bookworm.data.GenreRepository;
import bookmanager.app.bookworm.models.Genre;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/genre")
public class GenreController {
    private final GenreRepository genreRepository;

    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @GetMapping
    public String authorForm(Model model) {
        model.addAttribute("genre", new Genre());
        return "genre"; // Invoke ThymeLeaf template
    }

    @PostMapping
    public String saveAuthor(@ModelAttribute Genre genre) {
        genreRepository.save(genre);
        return "redirect:/genre";
    } 
}
