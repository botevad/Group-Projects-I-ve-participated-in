package bg.codeacademy.spring.project1.controller;

import bg.codeacademy.spring.project1.model.Comment;
import bg.codeacademy.spring.project1.service.BookService;
import bg.codeacademy.spring.project1.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books/{id}/comments ")
public class CommentController
{
  private final CommentService commentService;
  private final BookService    bookService;
  private final UserController userController;

  @Autowired
  public CommentController(CommentService commentService, BookService bookService, UserController userController)
  {
    this.commentService = commentService;
    this.bookService = bookService;
    this.userController = userController;
  }

  @PostMapping()
  public void addComment(@PathVariable Integer bookId,
                         @RequestBody Comment comment,
                         @RequestParam Integer userId)

  {
    comment.setBook(bookService.getBook(bookId));
    comment.setUser(userController.getUserById(userId));

    commentService.addComment(comment);
  }

  @GetMapping()
  public List<Comment> getAllBookComment(@PathVariable Integer bookId)
  {
    List<Comment> comments = new ArrayList<>();
    if (CollectionUtils.isEmpty(commentService.getAllComments(bookId))) {
      return comments;
    }

    return commentService.getAllComments(bookId);

  }


  @DeleteMapping("/{id}")
  public void removeComment(@PathVariable Integer commentId)
  {
    commentService.deleteComment(commentId);
  }


}

