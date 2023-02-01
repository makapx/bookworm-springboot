package bookmanager.app.bookworm.data;

import bookmanager.app.bookworm.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long>{
    List<Genre> findByName(String name);
}
