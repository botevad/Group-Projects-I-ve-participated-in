package bg.codeacademy.spring.progect1.service;


import bg.codeacademy.spring.progect1.model.Book;
import bg.codeacademy.spring.progect1.model.Comment;
import bg.codeacademy.spring.progect1.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class CommentServiceImpl implements CommentService
{
  @Autowired
  private CommentRepository commentRepository;

  @Override
  public void addComment(Integer bookId, Integer userId, Comment comment)
  {
    this.commentRepository.save(comment);
  }


  @Override
  public void deleteComment(Integer commentId)
  {
    this.commentRepository.deleteById(commentId);
  }

  @Override
  public Stack<Comment> getComment(Book book)
  {
    return commentRepository.findByBook(book);
  }
}
