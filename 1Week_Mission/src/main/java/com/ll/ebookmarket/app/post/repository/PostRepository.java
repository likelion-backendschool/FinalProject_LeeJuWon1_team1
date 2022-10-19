package com.ll.ebookmarket.app.post.repository;

import com.ll.ebookmarket.app.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}