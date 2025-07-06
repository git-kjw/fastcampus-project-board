package com.fastcampus.projectboard.controller.api;

import com.fastcampus.projectboard.dto.request.ArticleRequest;
import com.fastcampus.projectboard.dto.response.ArticleResponse;
import com.fastcampus.projectboard.dto.response.ArticleWithCommentsResponse;
import com.fastcampus.projectboard.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/articles")
public class ArticleRestController {
    private final ArticleService articleService;

    @GetMapping
    public Page<ArticleResponse> getArticles(@PageableDefault(size = 10) Pageable pageable) {
        return articleService.searchArticles(null, null, pageable).map(ArticleResponse::from);
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<ArticleWithCommentsResponse> getArticle(@PathVariable Long articleId) {
        return ResponseEntity.ok(ArticleWithCommentsResponse.from(articleService.getArticleWithComments(articleId)));
    }

    @PostMapping
    public ResponseEntity<Void> createArticle(@RequestBody ArticleRequest request) {
        articleService.saveArticle(request.toDto(null));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{articleId}")
    public ResponseEntity<Void> updateArticle(@PathVariable Long articleId, @RequestBody ArticleRequest request) {
        articleService.updateArticle(articleId, request.toDto(null));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{articleId}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long articleId) {
        articleService.deleteArticle(articleId, null);
        return ResponseEntity.noContent().build();
    }
}

