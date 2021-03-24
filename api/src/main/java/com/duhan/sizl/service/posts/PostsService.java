package com.duhan.sizl.service.posts;

import com.duhan.sizl.domain.posts.Posts;
import com.duhan.sizl.domain.posts.PostsRepository;
import com.duhan.sizl.web.dto.PostsListResponseDto;
import com.duhan.sizl.web.dto.PostsResponseDto;
import com.duhan.sizl.web.dto.PostsSaveRequestDto;
import com.duhan.sizl.web.dto.PostsUpdateRequestDto;
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
    public Long save(PostsSaveRequestDto requestsDto) {
        return postsRepository.save(requestsDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id) {
        Posts entity =  postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("id를 확인해주세요!!"));
        return new PostsResponseDto(entity);
    }
    @Transactional
    public String deleteById(Long id) {
        postsRepository.deleteById(id);
        return "ok";
    }
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
}
