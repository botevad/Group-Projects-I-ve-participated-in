package bg.codeacademy.spring.project1.service;

import bg.codeacademy.spring.project1.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

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
