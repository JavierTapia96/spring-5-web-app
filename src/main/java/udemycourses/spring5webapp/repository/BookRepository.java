package udemycourses.spring5webapp.repository;

import org.springframework.data.repository.CrudRepository;
import udemycourses.spring5webapp.entity.BookEntity;

public interface BookRepository extends CrudRepository<BookEntity, Long> {

}
