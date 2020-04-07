package bg.codeacademy.spring.project1.service;

import bg.codeacademy.spring.project1.model.Book;
import bg.codeacademy.spring.project1.model.Comment;
import bg.codeacademy.spring.project1.repository.CommentRepository;
import org.mockito.Mockito;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class CommentServiceTest {

    CommentRepository commentRepositoryMock = mock(CommentRepository.class);

    CommentService commentService = new CommentServiceImpl(commentRepositoryMock);

    @DataProvider(name = "comment-data")
    public Object[][] dataProviderMethod()
    {
        Comment comment1 = new Comment();


        Book book = new Book();
        book.setYear(2011);
        book.setAuthor("Ivan");
        book.setTitle("kniga");
        book.setId(21);

        UserDTO user = new UserDTO();
        user.setUsername("pesho");
        user.setId(99);


        comment1.setBook(book);
        comment1.setContent("komentar");
        comment1.setUser(user);

        return new Object[][]
                {
                        {comment1}
                };
    }

    @Test(dataProvider = "comment-data")
    public void it_should_add_comment(Comment comment)
    {
        commentService.addComment(comment);

        Mockito.verify(commentRepositoryMock, times(1)).save(comment);
    }

    @Test(dataProvider = "comment-data")
    public void it_should_get_comment(Comment comment)
    {
        Optional<Comment> commentOptional = commentService.getComment(comment.getId());

        Mockito.verify(commentRepositoryMock, times(1)).findById(comment.getId());
    }

    @Test(dataProvider = "comment-data")
    public void it_should_remove_comment(Comment comment)
    {
        commentService.deleteComment(comment.getId());

        Mockito.verify(commentRepositoryMock, times(1)).deleteById(comment.getId());
    }

    @Test(dataProvider = "comment-data")
    public void it_should_get_all_comments(Comment comment)
    {
        List<Comment> commentList = commentService.getAllComments(comment.getBook().getId());

        Mockito.verify(commentRepositoryMock, times(1)).findAllByBookId(comment.getBook().getId());
    }
}
