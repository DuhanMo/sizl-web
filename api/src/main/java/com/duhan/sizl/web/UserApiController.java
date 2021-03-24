package com.duhan.sizl.web;

import com.duhan.sizl.domain.user.User;
import com.duhan.sizl.service.posts.PostsService;
import com.duhan.sizl.service.user.UserService;
import com.duhan.sizl.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @GetMapping("home")
    public String home() {
        return "<h1>home<h1>";
    }
    @PostMapping("join")
    public ResponseEntity<?> join(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles("ROLE_USER");
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }
}
