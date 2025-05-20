
package kube.board.article.service.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ArticleUpdateRequest {
  private String title;
  private String content;
}