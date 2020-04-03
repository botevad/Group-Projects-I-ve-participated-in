package bg.codeacademy.spring.progect1.service;

import bg.codeacademy.spring.progect1.model.Book;
import bg.codeacademy.spring.progect1.model.Comment;

import java.util.List;

public interface CommentService
{
  void addComment(Book book, Comment comment);

  void editComment();

  void deleteComment();

  List<Comment> getComment(Book book);
}
