package bg.codeacademy.spring.project1.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookDTOWithComments extends BookDTO
{


  private List<CommentDTO> commentList = new ArrayList<>();

  public BookDTOWithComments()
  {
  }

  public List<CommentDTO> getCommentList() {
    Comparator<CommentDTO> comparatorByTime = (a, b) -> b.getTime().compareTo(a.getTime());
    commentList.sort(comparatorByTime);
    return
            Collections.unmodifiableList(commentList);
  }

  public BookDTOWithComments setCommentList(List<CommentDTO> commentList) {
    this.commentList = commentList;
    return this;
  }

}


