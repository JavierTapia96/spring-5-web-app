package udemycourses.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import udemycourses.spring5webapp.entity.AuthorEntity;
import udemycourses.spring5webapp.entity.BookEntity;
import udemycourses.spring5webapp.entity.PublisherEntity;
import udemycourses.spring5webapp.repository.AuthorRepository;
import udemycourses.spring5webapp.repository.BookRepository;
import udemycourses.spring5webapp.repository.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
        PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        PublisherEntity publisher = new PublisherEntity();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        AuthorEntity eric = new AuthorEntity("Eric", "Evans");
        BookEntity ddd = new BookEntity("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisherEntity(publisher);
        publisher.getBookEntities().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        AuthorEntity rod = new AuthorEntity("Rod", "Johnson");
        BookEntity noEJB = new BookEntity("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisherEntity(publisher);
        publisher.getBookEntities().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBookEntities().size());
    }
}
