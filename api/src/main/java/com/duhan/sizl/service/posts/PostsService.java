package com.duhan.sizl.service.posts;


import com.duhan.sizl.domain.posts.Posts;
import com.duhan.sizl.domain.posts.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional(readOnly = true)
    public List<Posts> findAll() {
        return postsRepository.findAll();
    }
}
