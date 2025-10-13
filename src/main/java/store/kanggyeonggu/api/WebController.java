package store.kanggyeonggu.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

	@GetMapping({"/", "/index"})
	public String index() {
		return "index";
	}

	@GetMapping({"/contents/calculator", "/contents/calculator/"})
	public String bmiCalculator() {
		return "contents/calculator/bmi";
	}

	@GetMapping({"/auth/login", "/login"})
	public String login() {
		return "auth/login";
	}

	@GetMapping({"/auth/register", "/register"})
	public String register() {
		return "auth/register";
	}
}


