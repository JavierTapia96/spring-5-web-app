package udemycourses.spring5webapp.repository;

import org.springframework.data.repository.CrudRepository;
import udemycourses.spring5webapp.entity.PublisherEntity;

public interface PublisherRepository extends CrudRepository<PublisherEntity, Long> {

}
