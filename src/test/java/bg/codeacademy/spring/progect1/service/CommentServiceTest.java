//package bg.codeacademy.spring.progect1.service;
//
//import bg.codeacademy.spring.project1.dto.UserDTO;
//import bg.codeacademy.spring.project1.model.Book;
//import bg.codeacademy.spring.project1.model.Comment;
//import bg.codeacademy.spring.project1.model.User;
//import bg.codeacademy.spring.project1.repository.CommentRepository;
//import bg.codeacademy.spring.project1.service.CommentService;
//import bg.codeacademy.spring.project1.service.CommentServiceImpl;
//import org.mockito.Mockito;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.times;
//
//public class CommentServiceTest {
//
//    CommentRepository commentRepositoryMock = mock(CommentRepository.class);
//
//    CommentService commentService = new CommentServiceImpl(commentRepositoryMock);
//
//    @DataProvider(name = "comment-data")
//    public Object[][] dataProviderMethod() {
//        Comment comment1 = new Comment();
//
//        Book book = new Book();
//        book.setYear(2011);
//        book.setAuthor("Ivan");
//        book.setTitle("kniga");
//        book.setId(21);
//
//        User user = new User();
//        user.setUsername("pesho");
//        user.setId(109);
//
//        comment1.setBook(book);
//        comment1.setContent("komentar");
//        comment1.setUser(user);
//
//
//        Comment comment2 = new Comment();
//        Book book1 = new Book();
//        book1.setYear(2111);
//        book1.setAuthor("Petkan");
//        book1.setTitle("knigataa");
//        book1.setId(31);
//
//        User user1 = new User();
//        user1.setUsername("rado");
//        user1.setId(99);
//
//        comment2.setBook(book1);
//        comment2.setContent("zloben komentar");
//        comment2.setUser(user1);
//
//        Comment comment3 = new Comment();
//        Book book2 = new Book();
//        book2.setYear(2111);
//        book2.setAuthor("avtor");
//        book2.setTitle("kniga1");
//        book2.setId(41);
//
//        User user2 = new User();
//        user2.setUsername("stefan");
//        user2.setId(59);
//
//        comment3.setBook(book2);
//        comment3.setContent("mnogo hubava kniga");
//        comment3.setUser(user2);
//
//        return new Object[][]
//                {
//                        {comment1}, {comment2}, {comment3}
//                };
//    }
//
//    @Test(dataProvider = "comment-data")
//    public void it_should_add_comment(Comment comment) {
//        commentService.addComment(comment);
//
//        Mockito.verify(commentRepositoryMock, times(1)).save(comment);
//    }
//
//    @Test(dataProvider = "comment-data")
//    public void it_should_get_comment(Comment comment) {
//        Optional<Comment> commentOptional = commentService.getComment(comment.getId());
//
//        Mockito.verify(commentRepositoryMock, times(1)).findById(comment.getId());
//    }
//
//    @Test(dataProvider = "comment-data")
//    public void it_should_remove_comment(Comment comment) {
//        commentService.deleteComment(comment.getId());
//
//        Mockito.verify(commentRepositoryMock, times(1)).deleteById(comment.getId());
//    }
//
//   @Test(dataProvider = "comment-data")
//    public void it_should_get_all_comments(Comment comment)
//    {
//        List<Comment> commentList = commentService.getAllComments(comment.getBook().getId());
//
//        Mockito.verify(commentRepositoryMock, times(1)).findAllByBookId(comment.getBook().getId());
//    }
//}
