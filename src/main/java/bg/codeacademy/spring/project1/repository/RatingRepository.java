package bg.codeacademy.spring.project1.repository;

import bg.codeacademy.spring.project1.model.Book;
import bg.codeacademy.spring.project1.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "ratings", path = "ratings")
public interface RatingRepository extends JpaRepository<Rating, Integer>
{
  List<Rating> findByBook(Book book);

  List<Rating> findRatingByBook_IdAndUser_Id(Integer bookId, Integer userId);
}
