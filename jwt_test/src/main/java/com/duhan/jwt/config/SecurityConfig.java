package com.duhan.jwt.config;

import com.duhan.jwt.filter.MyFilter1;
import com.duhan.jwt.filter.MyFilter3;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    private final CorsFilter corsFilter;
// 시큐리티는 쓰는데 세션을 쓰지 않으니 모든 페이지에 접근이 가능하다
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(new MyFilter3(), BasicAuthenticationFilter.class); // 필터비포 -> 시큐리티가 실행되기전에 필터해줌
        http.csrf().disable();
        // 기본적으로 웹은 stateless인데 stateful 처럼 쓰기위해 session, cookie를 썼던것. 여기선 STATELESS 상태로 진행하겠다 선언
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 세션을 안만듦
                .and()
                .addFilter(corsFilter) //인증이 없을때 -> @CorsFilter, 인증이 있을때 ->시큐리티 필터에 등록해줘야함
                .formLogin().disable() // form 태그로 로그인을 안함
                .httpBasic().disable() // 기본적인 http 로그인방식 안씀
                // 세션방식: 웹브라우저 쿠키영역에 sessionID를 저장하고 새로운요청을 할때 들고감
                // 단점: 서버가 여러개일 때 서버마다 메모리가 따로 있어 단점.
                //      기본적으로 동일 도메인에서만 쿠키가 발동함.
                //      클라이언트가 자바스크립트로(ajax,axios..) 쿠키 요청하게 되면 httpOnly로 인해 거부당함
                // basic 방식은 ID,PW를 달고 가는 방식
                // Bearer 방식은 Token 을 가지고가는 방식 (JWT)
                .authorizeRequests()
                .antMatchers("/api/v1/user/**")
                .access("hasRole('ROLE_USER') or hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
                .antMatchers("/api/v1/manager/**")
                .access("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
                .antMatchers("/api/v1/admin/**")
                .access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll();
    }
}
