package com.fastcampus.projectboard.repository;

import com.fastcampus.projectboard.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ArticleRepository extends JpaRepository<Article, Long> {

    Page<Article> findByTitleContaining(String title, Pageable pageable);

    Page<Article> findByHashtag(String hashtag, Pageable pageable);

    void deleteByIdAndUserAccount_UserId(Long articleId, String userId);

    @Query("SELECT DISTINCT a.hashtag FROM Article a WHERE a.hashtag IS NOT NULL")
    List<String> findAllDistinctHashtags();
}
