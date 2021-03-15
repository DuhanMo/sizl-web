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

    @Transactional(readOnly = true) // JPA 변경감지라는 내부 기능 활성화 X, update시의 정합성을 유지해줌. insert의 유령데이터현상(팬텀현상) 못막음.
    public Posts findById(Long id) {
        return postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("id를 확인해주세요!!"));
    }

    @Transactional
    public String deleteById(Long id) {
        postsRepository.deleteById(id); // 오류가 터지면 익셉션을 타니까.. 신경쓰지 말고
        return "ok";
    }
    @Transactional(readOnly = true)
    public List<Posts> findAll() {
        return postsRepository.findAll();
    }
}
