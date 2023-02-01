package bookmanager.app.bookworm.data;

import bookmanager.app.bookworm.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * GenreRepository
 * 
 * This interface is used to access the Genre table in the database.
 * The interface extends the JpaRepository interface,
 * which provides a few methods for accessing the database.
 * 
 * Type parameters:
 * Genre - the entity type
 * Long - the id type
 * 
 */
public interface GenreRepository extends JpaRepository<Genre, Long>{
    // Override the default method to find a genre by name
    List<Genre> findByName(String name);
}
