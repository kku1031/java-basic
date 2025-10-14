package store.kanggyeonggu.api.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginContoller {
    
    // 로그인 폼 제출을 처리하는 컨트롤러 (GET 방식)
    @GetMapping({"/auth/login"})
    public String loginSubmit(@RequestParam("name") String name,
        @RequestParam("password") String password) {
        System.out.println("😊name = " + name);
        System.out.println("😊password = " + password);
            return "auth/login";
    }
    
}
