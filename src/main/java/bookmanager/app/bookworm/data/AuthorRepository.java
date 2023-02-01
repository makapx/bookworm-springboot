package bookmanager.app.bookworm.data;

import bookmanager.app.bookworm.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * AuthorRepository
 * 
 * This interface is used to access the Author table in the database.
 * The interface extends the JpaRepository interface,
 * which provides a few methods for accessing the database.
 * 
 * Type parameters:
 * Author - the entity type
 * Long - the id type
 * 
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {
    // Override the default method to find an author by name
    List<Author> findByName(String name);
}