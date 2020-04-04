package bg.codeacademy.spring.project1.service;

import bg.codeacademy.spring.project1.model.Comment;

import java.util.List;

public interface CommentService
{
  void addComment(Comment comment);

  void deleteComment( Integer commentId);

  List<Comment> getAllComments(Integer bookId);
}
