package bookmanager.app.bookworm.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;

import java.util.List;

/**
 * Author
 * 
 */
@Entity
@Table(name="author")
public class Author {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToMany(mappedBy="author")
    private List<Book> books;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
