package com.duhan.sizl.service.posts;

import com.duhan.sizl.domain.posts.Posts;
import com.duhan.sizl.domain.posts.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;


    @Transactional
    public Posts save(Posts posts) {
        return postsRepository.save(posts);
    }

    @Transactional
    public Posts update(Long id, Posts posts) {
        Posts postsEntity = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("id를 확인해주세요!!")); //
        postsEntity.setTitle(posts.getTitle());
        postsEntity.setAuthor(posts.getAuthor());
        return postsEntity;
    }

    @Transactional(readOnly = true)
    public Posts findById(Long id) {
        return postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("id를 확인해주세요!!"));
    }

    @Transactional
    public String deleteById(Long id) {
        postsRepository.deleteById(id);
        return "ok";
    }
    @Transactional(readOnly = true)
    public List<Posts> findAll() {
        return postsRepository.findAll();
    }
}
