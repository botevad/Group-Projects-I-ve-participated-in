package bg.codeacademy.spring.progect1.controller;


import bg.codeacademy.spring.progect1.model.Comment;
import bg.codeacademy.spring.progect1.service.BookService;
import bg.codeacademy.spring.progect1.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController
{
  @Autowired
  private CommentService commentService;
  @Autowired
  BookService bookService;

  @PostMapping()// ? does it need a URL path
  public void addComment(@RequestParam Integer bookId,
                         @RequestBody Comment comment,
                         @RequestParam Integer userId)
  {
    commentService.addComment(bookId, userId, comment);
  }

  @PostMapping()// ???? needs an URL
  public void deleteComment(@RequestParam Integer commentId)
  {
    commentService.deleteComment(commentId);
  }

  // TODO validation max char.. 256chars Comment must start with Upper case letter and ends with "."
}
