package site.metacoding.blogv2.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.domain.user.User;
import site.metacoding.blogv2.service.UserService;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;
    private final HttpSession session;

    // HTTP (WEB) 용 로그아웃 메서드
    // @GetMapping("/logout")
    // public String logout() {
    //     session.invalidate();
    //     return "redirect:/";
    // }

    // HTTP (WEB) 용 회원정보수정 메서드
    // @GetMapping("/s/user/{id}")
    // public String userinfo(Model model) {
    //     // DB에서 데이터 받아서 model에 담아서 리턴
    //     return "user/updateForm";
    // }

    @GetMapping("/s/user/{id}")
    public String userinfo(Model model, @PathVariable Integer id) {
        User userEntity = userService.회원정보(id);
        model.addAttribute("user", userEntity);
        return "user/updateForm";
    }

    // 웹브라우저 -> 회원가입 페이지 주세요!!
    // 앱 -> 회원가입 페이지 주세요!! 말이 안됨!!
    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @GetMapping("/loginForm")
    public String loginForm(HttpServletRequest request, Model model) {
        // 쿠키로직
        String cookieValue = request.getHeader("Cookie");
        return "user/loginForm";
    }
}