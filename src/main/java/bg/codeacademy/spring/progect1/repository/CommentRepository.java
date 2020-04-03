package bg.codeacademy.spring.progect1.repository;


import bg.codeacademy.spring.progect1.model.Book;
import bg.codeacademy.spring.progect1.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Stack;


@RepositoryRestResource(collectionResourceRel = "resumes", path = "resumes")
public interface CommentRepository extends JpaRepository<Comment, Integer>
{
  Stack<Comment> findByBook (Book book);
}
