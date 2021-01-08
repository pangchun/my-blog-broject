package com.pangchun.blog.home.blog.repository;

import com.pangchun.blog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article,Integer> {

    Article findFirstByOrderByPublishTimeDesc();
}
