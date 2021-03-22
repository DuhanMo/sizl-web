package com.duhan.sizl.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {
    @GetMapping("home")
    public String home() {
        return "<h1>home<h1>";
    }
}
