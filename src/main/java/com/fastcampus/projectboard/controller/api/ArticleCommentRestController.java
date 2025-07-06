package com.fastcampus.projectboard.controller.api;

import com.fastcampus.projectboard.dto.request.ArticleCommentRequest;
import com.fastcampus.projectboard.dto.response.ArticleCommentResponse;
import com.fastcampus.projectboard.service.ArticleCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comments")
public class ArticleCommentRestController {
    private final ArticleCommentService articleCommentService;

    @GetMapping("/article/{articleId}")
    public ResponseEntity<List<ArticleCommentResponse>> getCommentsByArticle(@PathVariable Long articleId) {
        List<ArticleCommentResponse> comments = articleCommentService.searchArticleComments(articleId).stream().map(ArticleCommentResponse::from).toList();
        return ResponseEntity.ok(comments);
    }

    @PostMapping
    public ResponseEntity<Void> createComment(@RequestBody ArticleCommentRequest request) {
        articleCommentService.saveArticleComment(request.toDto(null));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<Void> updateComment(@PathVariable Long commentId, @RequestBody ArticleCommentRequest request) {
        articleCommentService.updateArticleComment(request.toDto(null));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        articleCommentService.deleteArticleComment(commentId, null);
        return ResponseEntity.noContent().build();
    }
}
