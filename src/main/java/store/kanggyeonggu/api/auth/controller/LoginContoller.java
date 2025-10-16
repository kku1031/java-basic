package store.kanggyeonggu.api.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import store.kanggyeonggu.api.auth.domain.LoginDTO;
import store.kanggyeonggu.api.auth.service.LoginService;

@Controller
public class LoginContoller {

    private final LoginService loginService; // 속성이 없으니까 Service의 속성 끌어옴

    public LoginContoller(LoginService loginService) {
        this.loginService = loginService;
    }

    // 로그인 폼 제출을 처리하는 컨트롤러 (GET 방식)
    @GetMapping({ "/auth/login" })
    public String loginSubmit(@RequestParam("name") String name,
            @RequestParam("password") String password) {
        System.out.println("로그인 서비스로 들어옴");
        System.out.println("화면에서 로그인서비스로 전달된 이메일 : " + name);
        System.out.println("화면에서 로그인서비스 전달된 비밀번호 : " + password);

        LoginDTO loginDTO = new LoginDTO(); // 객체 (메모리에 객체의 주소를 만들어라) ->지역변수,
        // 현업에서는 그냥 다 속성으로 퉁침.
        loginDTO.setName(name);
        loginDTO.setPassword(password);

        loginService.login(loginDTO);

        return "auth/login";
    }
}
