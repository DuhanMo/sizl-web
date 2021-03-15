package com.duhan.sizl.web;

import com.duhan.sizl.domain.posts.Posts;
import com.duhan.sizl.service.posts.PostsService;
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
    public ResponseEntity<?> save(@RequestBody Posts posts) {
        return new ResponseEntity<>(postsService.save(posts), HttpStatus.CREATED); // 200
    }


    @CrossOrigin
    @PutMapping("/api/v1/posts/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Posts posts) {
        return new ResponseEntity<>(postsService.update(id, posts), HttpStatus.OK); // 200
    }


    @CrossOrigin
    @GetMapping("/api/v1/posts/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(postsService.findById(id), HttpStatus.OK); // 200
    }
    @CrossOrigin
    @DeleteMapping("/api/v1/posts/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(postsService.deleteById(id), HttpStatus.OK); // 200
    }


}
