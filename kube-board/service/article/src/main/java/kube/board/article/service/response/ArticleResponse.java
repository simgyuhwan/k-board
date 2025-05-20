package kube.board.article.service.response;

import java.time.LocalDateTime;
import kube.board.article.entity.Article;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ArticleResponse {
  private Long articleId;
  private String title;
  private String content;
  private Long boardId;
  private Long writeId;
  private LocalDateTime createAt;
  private LocalDateTime modifiedAt;

  public static ArticleResponse from(Article article) {
    ArticleResponse response = new ArticleResponse();
    response.articleId = article.getArticleId();
    response.title = article.getTitle();
    response.content = article.getContent();
    response.boardId = article.getBoardId();
    response.writeId = article.getWriterId();
    response.createAt = article.getCreatedAt();
    response.modifiedAt = article.getModifiedAt();
    return response;
  }
}
