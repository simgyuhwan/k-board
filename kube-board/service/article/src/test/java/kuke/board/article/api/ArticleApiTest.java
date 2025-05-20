package kuke.board.article.api;

import kube.board.article.service.response.ArticleResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestClient;

public class ArticleApiTest {

  RestClient restClient = RestClient.create("http://localhost:8000");

  @Test
  void createTest() {
    ArticleResponse response = create(new ArticleCreateRequest("hi", "first content", 1L, 1L));
    System.out.println("response: " + response);
  }

  @Test
  void readTest(){
    ArticleResponse response = read(183106632014106624L);
    System.out.println("response : " + response);
  }

  @Test
  void updateTest(){
    update(183106632014106624L,
        new ArticleUpdateRequest("update title", "update content"));
    ArticleResponse response = read(183106632014106624L);
    System.out.println("response : " + response);
  }

  @Test
  void deleteTest(){
    delete(183106632014106624L);
  }

  private void delete(long articleId) {
    restClient.delete()
        .uri("/v1/articles/{articleId}", articleId)
        .retrieve();
  }

  ArticleResponse update(Long articleId, ArticleUpdateRequest request) {
    return restClient.put()
        .uri("/v1/articles/{articleId}", articleId)
        .body(request)
        .retrieve()
        .body(ArticleResponse.class);
  }

  ArticleResponse read(Long articleId) {
    return restClient.get()
        .uri("/v1/articles/{articleId}", articleId)
        .retrieve()
        .body(ArticleResponse.class);
  }

  ArticleResponse create(ArticleCreateRequest request) {
    return restClient.post()
        .uri("/v1/articles")
        .body(request)
        .retrieve()
        .body(ArticleResponse.class);
  }

  @Getter
  @AllArgsConstructor
  static class ArticleCreateRequest {
    private String title;
    private String content;
    private Long writerId;
    private Long boardId;
  }

  @Getter
  @AllArgsConstructor
  static class ArticleUpdateRequest {
    private String title;
    private String content;
  }
}
