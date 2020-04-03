package bg.codeacademy.spring.progect1.controller;

import bg.codeacademy.spring.progect1.dto.BookDto;
import bg.codeacademy.spring.progect1.model.Book;
import bg.codeacademy.spring.progect1.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController
{
  private BookService bookService;

/*  @GetMapping("/")
  public List<Book> getAllBooks()
  {

    } */


}
