package bg.codeacademy.spring.project1.repository;


import bg.codeacademy.spring.project1.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "resumes", path = "resumes")
public interface CommentRepository extends JpaRepository<Comment, Integer>
{
  List<Comment> findAllByBook(Integer bookId);
}
