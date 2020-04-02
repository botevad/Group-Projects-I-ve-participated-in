package bg.codeacademy.spring.progect1.repository;

import bg.codeacademy.spring.progect1.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "resumes", path = "resumes")
public interface ResumeRepository extends JpaRepository<Comment, Integer>
{

}
