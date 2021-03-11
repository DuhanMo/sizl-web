package com.duhan.sizl.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 페이지 이동 컨트롤러
 */
@RestController
public class IndexController {
//    private final PostsService postsService;

    @GetMapping("/")
    public String hello() {return "";}
}
