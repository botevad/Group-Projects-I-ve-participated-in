package bg.codeacademy.spring.progect1.service;

import bg.codeacademy.spring.progect1.model.Book;
import bg.codeacademy.spring.progect1.model.Comment;

import java.util.List;
import java.util.Stack;

public interface CommentService
{
  void addComment(Integer bookId,Integer userId, Comment comment);

  void deleteComment( Integer commentId);

  Stack<Comment> getComment(Book book);
}
