package udemycourses.spring5webapp.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;
    @ManyToOne
    private PublisherEntity publisherEntity;
    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<AuthorEntity> authorEntities = new HashSet<>();

    public BookEntity() {
    }

    public BookEntity(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<AuthorEntity> getAuthors() {
        return authorEntities;
    }

    public void setAuthors(Set<AuthorEntity> authorEntities) {
        this.authorEntities = authorEntities;
    }

    public PublisherEntity getPublisherEntity() {
        return publisherEntity;
    }

    public void setPublisherEntity(PublisherEntity publisherEntity) {
        this.publisherEntity = publisherEntity;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", isbn='" + isbn + '\'' +
            ", authorEntities=" + authorEntities +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BookEntity bookEntity = (BookEntity) o;

        return Objects.equals(id, bookEntity.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
