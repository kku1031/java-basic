package store.kanggyeonggu.api.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping({"/"})
    public String index() {         
        System.out.println("메인 페이지 접근");
        return "index";                
    }

    @GetMapping({"/auth/login.html"})
    public String loginHtml() {
        return "auth/login";
    }

    @GetMapping({"/auth/register.html"})
    public String registerHtml() {
        return "auth/register";
    }
    
}
