package bg.codeacademy.spring.project1.service;

import bg.codeacademy.spring.project1.model.Comment;
import bg.codeacademy.spring.project1.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService
{
  private final CommentRepository commentRepository;

  @Autowired
  public CommentServiceImpl(CommentRepository commentRepository)
  {
    this.commentRepository = commentRepository;
  }

  @Override
  public void addComment(Comment comment)
  {
    commentRepository.save(comment);
  }

  @Override
  public void deleteComment(Integer commentId)
  {
    commentRepository.deleteById(commentId);
  }

  @Override
  public List<Comment> getAllComments(Integer bookId)
  {
    return commentRepository.findAllByBook(bookId);
  }
}
