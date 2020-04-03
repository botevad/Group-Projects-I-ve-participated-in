package bg.codeacademy.spring.progect1.service;

import bg.codeacademy.spring.progect1.model.Book;
import bg.codeacademy.spring.progect1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService
{

  @Autowired
  private BookRepository bookRepository;

  @Override
  public Book getBook(Integer id)
  {
    return bookRepository.findById(id).get();
  }

  @Override
  public Book addBook(Book book)
  {
    return bookRepository.save(book);
  }

  @Override
  public void removeBook(Integer id)
  {
    bookRepository.deleteById(id);
  }

  @Override
  public Book editBook(Integer id, Book book)
  {
    Book b = getBook(id);
    b.setAuthor(book.getAuthor());
    b.setTitle(book.getTitle());
    b.setYear(book.getYear());
    return b;
  }

  @Override
  public List<Book> findAllBooks()
  {
    return bookRepository.findAll();
  }

  @Override
  public List<Book> findBookByCriteria(String title, String author, Integer year)
  {
    List<Book> books = bookRepository.findByTitleContainingOrAuthorContainingOrYearIs(title, author, year);
    return books;
  }
}
