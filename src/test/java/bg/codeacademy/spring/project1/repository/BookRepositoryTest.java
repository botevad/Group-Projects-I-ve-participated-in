package bg.codeacademy.spring.project1.repository;

import bg.codeacademy.spring.project1.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

@DataJpaTest
public class BookRepositoryTest extends AbstractTestNGSpringContextTests {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    BookRepository bookRepository;

    @Test
    public void it_should_save_book() {
        Book book = new Book();
        book.setId(21);
        book.setYear(2013);
        book.setAuthor("Pavel Ivanov");
        book.setTitle("Ross");

        book = entityManager.persistAndFlush(book);
        Assert.assertEquals(bookRepository.findById(book.getId()).get(), book);
    }
}
