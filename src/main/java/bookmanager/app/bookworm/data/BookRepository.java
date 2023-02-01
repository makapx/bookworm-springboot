package bookmanager.app.bookworm.data;

import bookmanager.app.bookworm.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * BookRepository
 * 
 * This interface is used to access the Book table in the database.
 * The interface extends the JpaRepository interface,
 * which provides a few methods for accessing the database.
 * 
 * Type parameters:
 * Book - the entity type
 * Long - the id type
 * 
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    // Override the default method to find a book by title, author, or genre
    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
    List<Book> findByGenre(String genre);
}
