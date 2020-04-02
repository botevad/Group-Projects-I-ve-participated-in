package bg.codeacademy.spring.progect1.service;

import bg.codeacademy.spring.progect1.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService
{

  int getBookID();

  String getBookName();

  String getBookAuthor();

  String getBookTitle();

  int getBookYear();

  double getBookPrice();

  double getBookRating();

  String getBookComments();

  void addBook(Book book);

  void removeBook(Integer id);

  Book editBook(Integer id);

  List<Book> findAllBooks();

  Book findBookByCriteria(String title, String author, int date);
}
