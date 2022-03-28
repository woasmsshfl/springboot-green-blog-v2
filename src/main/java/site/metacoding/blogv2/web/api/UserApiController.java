package site.metacoding.blogv2.web.api;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.domain.user.User;
import site.metacoding.blogv2.service.UserService;
import site.metacoding.blogv2.web.api.dto.ResponseDto;
import site.metacoding.blogv2.web.api.dto.user.JoinDto;
import site.metacoding.blogv2.web.api.dto.user.LoginDto;
import site.metacoding.blogv2.web.api.dto.user.UpdateDto;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;
    private final HttpSession session;

    // 회원가입
    @PostMapping("/join")
    public ResponseDto<?> join(@RequestBody JoinDto joinDto) {
        userService.회원가입(joinDto);
        return new ResponseDto<>(1, "회원가입성공", null);
    }

    // 로그인
    @PostMapping("/login")
    public ResponseDto<?> login(@RequestBody LoginDto loginDto, HttpServletResponse response) {

        User userEntity = userService.로그인(loginDto);

        if (userEntity == null) {
            return new ResponseDto<>(-1, "로그인실패", null);
        }

        session.setAttribute("principal", userEntity);

        if (loginDto.getRemember().equals("on")) {
            System.out.println(loginDto.getRemember());
            response.addHeader("Set-cookie", "remember = " + loginDto.getUsername() + "; path=/");
        }

        // response.addHeader("Set-cookie", "remember = " + loginDto.getUsername() + "; path=/ HttpOnly");

        // Cookie cookie = new Cookie("remember", loginDto.getUsername());
        // cookie.setPath("/");
        // response.addCookie(cookie);

        return new ResponseDto<String>(1, "로그인성공", null);
    }

    // 로그아웃
    @GetMapping("/logout")
    public ResponseDto<?> logout() {
        session.invalidate();
        return new ResponseDto<>(1, "로그아웃", null);
    }
    
    // // 회원정보
    // @GetMapping("/s/api/user/{id}")
    // public ResponseDto<?> userinfo(@PathVariable Integer id, Model model) {
    //     User userEntity = userService.회원정보(id);
    //     return new ResponseDto<>(1, "성공", userEntity);
    // }
    
    // password, email, addr 만 수정가능하게 Dto를 받는다.
    // 회원정보수정
    @PutMapping("/s/api/user/{id}")
    public ResponseDto<?> update(@PathVariable Integer id, @RequestBody UpdateDto updateDto) {
        User userEntity = userService.회원수정(id, updateDto);
        session.setAttribute("principal", userEntity); // 세선 변경하기.
        return new ResponseDto<>(1, "성공", null);
    }
}