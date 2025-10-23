package store.kanggyeonggu.api.auth.controller;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// import ch.qos.logback.core.model.Model;
import store.kanggyeonggu.api.auth.domain.LoginDTO;
import store.kanggyeonggu.api.auth.service.LoginService;
import store.kanggyeonggu.api.common.domain.Messenger;
import store.kanggyeonggu.api.user.domain.UserDTO;

@Controller
public class LoginContoller implements LoginService {

    private final LoginService loginService; // 속성이 없으니까 Service의 속성 끌어옴

    public LoginContoller(LoginService loginService) {
        this.loginService = loginService;
    }

    // 로그인 폼 제출을 처리하는 컨트롤러 (GET 방식)
    @GetMapping({ "/auth/login" })
    public String loginSubmit(@RequestParam("name") String name,
            @RequestParam("password") String password, Model model) {

        LoginDTO loginDTO = new LoginDTO(); // 객체 (메모리에 객체의 주소를 만들어라) ->지역변수,
        // 현업에서는 그냥 다 속성으로 퉁침.
        loginDTO.setName(name);
        loginDTO.setPassword(password);

        Messenger messenger = loginService.login(loginDTO); // => 객체를 초기화 한다.

        if (messenger.getCode() == 0) {
            // 로그인 성공 시: train.csv 로드하여 상위 5개를 터미널에 출력하고 user/list로 렌더링
            try {
                ClassPathResource resource = new ClassPathResource("static/csv/train.csv");
                List<CSVRecord> records = new ArrayList<>();

                try (Reader reader = new InputStreamReader(resource.getInputStream());
                        CSVParser parser = CSVFormat.Builder.create()
                                .setHeader()
                                .setSkipHeaderRecord(true)
                                .setTrim(true)
                                .build()
                                .parse(reader)) {

                    for (CSVRecord record : parser) {
                        records.add(record);
                    }
                }

                List<UserDTO> userDTOList = new ArrayList<>();
                int count = 0;
                for (CSVRecord record : records) {
                    if (count >= 5)
                        break;
                    userDTOList.add(new UserDTO(record));
                    count++;
                }

                // 터미널 출력 (상위 5개)
                System.out.println("[LOGIN SUCCESS] Loaded users from train.csv (top " + userDTOList.size() + ")");
                for (UserDTO u : userDTOList) {
                    System.out.println(u);
                }

                model.addAttribute("users", userDTOList);
                return "user/list";
            } catch (Exception e) {
                // CSV 로딩 실패 시에도 로그인 화면으로 에러 메시지 표시
                messenger.setCode(3);
                messenger.setMessage("데이터 로딩 실패");
            }
        }

        // 실패 시: 메시지와 함께 로그인 화면으로
        model.addAttribute("messenger", messenger);
        return "auth/login";
    }

    @Override
    public Messenger login(LoginDTO loginDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }
}
