package store.kanggyeonggu.api.common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping({ "/" })
    public String index() {
        return "index";
    }

    @GetMapping({ "/auth/login.html" })
    public String loginHtml() {
        return "auth/login";
    }

    @GetMapping({ "/auth/register.html" })
    public String registerHtml() {
        return "auth/register";
    }

}
