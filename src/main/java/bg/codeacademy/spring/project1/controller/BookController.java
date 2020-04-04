package bg.codeacademy.spring.project1.controller;

import bg.codeacademy.spring.project1.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
