package com.duhan.jwt.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter3 implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        // 토큰을 만들었다고 가정 : 코스
        // ID,PW 가 정상적으로 들어와서 로그인이 완료되면 토큰을 만들어주고 그걸 응답을 해준다
        // 요청 할때마다 header에 authorization 에 value값으로 토큰을 가지고 옴
        // 그 때 토큰이 넘어오면 이 토큰이 내가 만든 토큰이 맞는지 검증만 하면됨 cos가 아니라.
        // 코스라는 토큰이 오면 필터계속 체이닝
        // 코스라는 토큰이 아니라면 컨트롤러로 접근조차 못하게
        if (req.getMethod().equals("POST")) {
            System.out.println("POST 요청됨");
            String headerAuth = req.getHeader("Authorization");
            System.out.println(headerAuth);
            if (headerAuth.equals("cos")) {
                filterChain.doFilter(req, res);
            } else {
                PrintWriter out = res.getWriter();
                out.println("인증안됨");
            }
        }
    }

}
