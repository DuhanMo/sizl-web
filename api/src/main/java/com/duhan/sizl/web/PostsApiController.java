package com.duhan.sizl.web;

import com.duhan.sizl.domain.posts.Posts;
import com.duhan.sizl.service.posts.PostsService;
import com.duhan.sizl.web.dto.PostsResponseDto;
import com.duhan.sizl.web.dto.PostsSaveRequestDto;
import com.duhan.sizl.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @CrossOrigin
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @CrossOrigin
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    //    @GetMapping("/api/v1/posts/{id}")
//    public ResponseEntity<?> findById(@PathVariable Long id) {
//        return new ResponseEntity<>(postsService.findById(id), HttpStatus.OK);
//    }
    @CrossOrigin
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }


}
