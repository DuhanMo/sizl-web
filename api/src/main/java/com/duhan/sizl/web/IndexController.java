package com.duhan.sizl.web;

import com.duhan.sizl.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 페이지 이동 컨트롤러
 */
@RequiredArgsConstructor
@RestController
public class IndexController {
    private final PostsService postsService;

    @CrossOrigin
    @GetMapping("/posts")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(postsService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/api/hello")
    public String hello(){
        return "안녕하세요. 현재 서버시간은 "+new Date() +"입니다. \n";
    }
}
