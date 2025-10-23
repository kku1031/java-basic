package store.kanggyeonggu.api.user.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import store.kanggyeonggu.api.user.domain.UserDTO;
import store.kanggyeonggu.api.user.service.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // 로그인 성공 후 클라이언트 alert 확인 뒤 이동할 user/list 랜더링 엔드포인트
    @PostMapping("/all")
    public String saveAll(Model model) throws Exception {
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

        List<UserDTO> users = new ArrayList<>();
        int count = 0;
        for (CSVRecord record : records) {
            if (count >= 5)
                break;
            users.add(new UserDTO(record));
            count++;
        }

        model.addAttribute("users", users);

        return "user/list";
    }

    // 회원가입 성공 시: weather 데이터를 읽어 weather/list 로 렌더링 (임시 구현)
    @GetMapping("/register")
    public String registerAndShowWeather(Model model) throws Exception {
        ClassPathResource resource = new ClassPathResource("static/csv/TEST_weather_00.csv-Grid view.csv");

        List<CSVRecord> records;
        try (Reader reader = new InputStreamReader(resource.getInputStream());
                CSVParser parser = CSVFormat.Builder.create()
                        .setHeader()
                        .setSkipHeaderRecord(true)
                        .setTrim(true)
                        .build()
                        .parse(reader)) {
            records = parser.getRecords();
        }

        List<store.kanggyeonggu.api.weather.domain.WeatherDTO> weathers = new ArrayList<>();
        int count = 0;
        for (CSVRecord record : records) {
            if (count >= 5)
                break;
            weathers.add(new store.kanggyeonggu.api.weather.domain.WeatherDTO(record));
            count++;
        }

        model.addAttribute("weathers", weathers);

        return "weather/list";
    }

}
