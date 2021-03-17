package com.duhan.sizl.web;

import com.duhan.sizl.domain.posts.Posts;
import com.duhan.sizl.service.posts.PostsService;
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
    public ResponseEntity<?> save(@RequestBody PostsSaveRequestDto requestsDto) {
        return new ResponseEntity<>(postsService.save(requestsDto), HttpStatus.CREATED);
    }


//    @CrossOrigin
//    @PutMapping("/api/v1/posts/{id}")
//    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Posts posts) {
//        return new ResponseEntity<>(postsService.update(id, posts), HttpStatus.OK);
//    }
//    @PutMapping("/api/v1/posts/{id}")
//    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
//        return postsService.update(id, requestDto);
//    }

    @CrossOrigin
    @PutMapping("/api/v1/posts/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return new ResponseEntity<>(postsService.update(id, requestDto), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/api/v1/posts/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        return new ResponseEntity<>(postsService.findById(id), HttpStatus.OK);
    }
    @CrossOrigin
    @DeleteMapping("/api/v1/posts/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(postsService.deleteById(id), HttpStatus.OK);
    }


}
