package com.ll.ebookmarket.app.post.service;

import com.ll.ebookmarket.app.base.exception.DataNotFoundException;
import com.ll.ebookmarket.app.hashtag.service.HashTagService;
import com.ll.ebookmarket.app.member.entity.Member;
import com.ll.ebookmarket.app.post.entity.Post;
import com.ll.ebookmarket.app.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final HashTagService hashTagService;

    public Page<Post> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return this.postRepository.findAll(pageable);
    }

    public Post getPostById(Long id) {
        Optional<Post> post = this.postRepository.findById(id);
        if (post.isPresent()) {
            return post.get();
        } else {
            throw new DataNotFoundException("Post not found");
        }
    }

    public void write(Member author, String subject, String content, String contentHtml, String hashTagContents) {
        Post post = Post
                .builder()
                .author(author)
                .subject(subject)
                .content(content)
                .contentHtml(contentHtml)
                .build();

        this.postRepository.save(post);

        hashTagService.applyHashTags(post, hashTagContents);
    }

    public void modify(Post post, String subject, String content, String contentHtml, String hashTagContents) {
        post.setSubject(subject);
        post.setContent(content);
        post.setContentHtml(contentHtml);
        this.postRepository.save(post);

        hashTagService.applyHashTags(post, hashTagContents);
    }

    public void delete(Post post) {
        this.postRepository.delete(post);
    }
}
