package bg.codeacademy.spring.project1.service;

import bg.codeacademy.spring.project1.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService
{
  Book getBook(Integer id);

  Book addBook(Book book);

  void removeBook(Integer id);

  Book editBook(Integer id, Book book);

  List<Book> findAllBooks();

  List<Book> findBookByCriteria(String title, String author, Integer date);
}