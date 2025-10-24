package store.kanggyeonggu.api.auth.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import store.kanggyeonggu.api.auth.domain.LoginDTO;
import store.kanggyeonggu.api.auth.service.LoginService;
import store.kanggyeonggu.api.common.domain.Messenger;
import store.kanggyeonggu.api.user.domain.UserDTO;

@Controller
public class LoginContoller implements LoginService {

    private final LoginService loginService;

    public LoginContoller(LoginService loginService) {
        this.loginService = loginService;
    }

    // 로그인 폼 제출을 처리하는 컨트롤러 (GET 방식)
    @GetMapping({ "/auth/login" })
    public String loginSubmit(@RequestParam("name") String name,
            @RequestParam("password") String password, Model model) {

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setName(name);
        loginDTO.setPassword(password);

        Messenger messenger = loginService.login(loginDTO);

        if (messenger.getCode() == 0) {
            // 로그인 성공 시: 새로운 UserController 구조 사용
            try {
                List<UserDTO> userList = parseDefaultCsvFile();

                // 터미널 출력 (상위 5개)
                System.out.println("[LOGIN SUCCESS] Loaded users from train.csv (top " + userList.size() + ")");
                for (int i = 0; i < Math.min(5, userList.size()); i++) {
                    System.out.println(userList.get(i));
                }

                model.addAttribute("users", userList);
                Messenger successMessenger = new Messenger(200, "로그인 성공! 기본 데이터 " + userList.size() + "개가 로드되었습니다.");
                model.addAttribute("messenger", successMessenger);
                return "user/list";
            } catch (Exception e) {
                // CSV 로딩 실패 시에도 로그인 화면으로 에러 메시지 표시
                messenger.setCode(3);
                messenger.setMessage("데이터 로딩 실패: " + e.getMessage());
            }
        }

        // 실패 시: 메시지와 함께 로그인 화면으로
        model.addAttribute("messenger", messenger);
        return "auth/login";
    }

    // 기본 CSV 파일을 파싱하여 UserDTO 리스트로 변환 (UserController와 동일한 로직)
    private List<UserDTO> parseDefaultCsvFile() throws Exception {
        String content;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new java.io.FileInputStream("src/main/resources/static/csv/train.csv"),
                        StandardCharsets.UTF_8))) {
            content = reader.lines()
                    .collect(Collectors.joining("\n"))
                    .replace("\uFEFF", ""); // BOM 제거
        }

        return parseCsvContent(content);
    }

    // CSV 내용을 파싱하여 UserDTO 리스트로 변환 (공통 로직)
    private List<UserDTO> parseCsvContent(String content) throws Exception {
        CSVParser parser = CSVParser.parse(
                content,
                CSVFormat.Builder.create()
                        .setHeader()
                        .setTrim(true)
                        .build());

        List<UserDTO> userList = new ArrayList<>();
        for (CSVRecord record : parser) {
            UserDTO userDTO = new UserDTO();
            userDTO.setPassengerId(record.get("PassengerId"));
            userDTO.setSurvived(record.get("Survived"));
            userDTO.setPclass(record.get("Pclass"));
            userDTO.setName(record.get("Name"));
            userDTO.setSex(record.get("Sex"));
            userDTO.setAge(record.get("Age"));
            userDTO.setSibSp(record.get("SibSp"));
            userDTO.setParch(record.get("Parch"));
            userDTO.setTicket(record.get("Ticket"));
            userDTO.setFare(record.get("Fare"));
            userDTO.setCabin(record.get("Cabin"));
            userDTO.setEmbarked(record.get("Embarked"));
            userList.add(userDTO);
        }
        return userList;
    }

    @Override
    public Messenger login(LoginDTO loginDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }
}
