package com.duhan.sizl.config.jwt;

public interface JwtProperties {
    String SECRET = "모두한"; // 우리 서버만 알고 있는 비밀값
    int EXPIRATION_TIME = 600000; // 10일 (1/1000초)
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
}