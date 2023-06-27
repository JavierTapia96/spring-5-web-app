package udemycourses.spring5webapp.repository;

import org.springframework.data.repository.CrudRepository;
import udemycourses.spring5webapp.entity.AuthorEntity;

public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {

}
