package bg.codeacademy.spring.project1.controller;

import bg.codeacademy.spring.project1.model.Comment;
import bg.codeacademy.spring.project1.service.BookService;
import bg.codeacademy.spring.project1.service.CommentService;
import bg.codeacademy.spring.project1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.executable.ValidateOnExecution;
import java.util.ArrayList;
import java.util.List;

@RestController
@Validated
@RequestMapping("/books/{id}/comments ")
public class CommentController
{
  private final CommentService commentService;
  private final BookService bookService;
  private final UserService userService;

  @Autowired
  public CommentController(CommentService commentService, BookService bookService, UserService userService)
  {
    this.commentService = commentService;
    this.bookService = bookService;
    this.userService = userService;
  }

  @PostMapping()
  public void addComment(@PathVariable @NotNull Integer bookId,
                         @RequestBody @Valid Comment comment,
                         @RequestParam @NotNull Integer userId)

  {
    comment.setBook(bookService.getBook(bookId));
    comment.setUser(userService.getUser(userId));

    commentService.addComment(comment);
  }

  @GetMapping()
  public List<Comment> getAllBookComment(@PathVariable @NotNull Integer bookId)
  {
    List<Comment> comments = new ArrayList<>();
    if (CollectionUtils.isEmpty(commentService.getAllComments(bookId))) {
      return comments;
    }

    return commentService.getAllComments(bookId);

  }


  @DeleteMapping("/{id}")
  public void removeComment(@PathVariable @NotNull Integer commentId)
  {
    commentService.deleteComment(commentId);
  }


}

