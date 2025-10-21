package store.kanggyeonggu.api.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import store.kanggyeonggu.api.user.service.UserService;
import store.kanggyeonggu.api.user.domain.UserDTO;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // CSV 데이터 처리 및 로딩
    @GetMapping("auth/register")
    public List<UserDTO> processAllCsvData() throws Exception {
        // CSV 파일 읽기
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
            System.out.println("총 " + records.size() + "개의 데이터를 읽었습니다.");
        }

        // CSV 데이터를 UserDTO로 변환 (5개만)
        List<UserDTO> userDTOList = new ArrayList<>();
        int count = 0;
        for (CSVRecord record : records) {
            if (count >= 5)
                break;

            UserDTO userDTO = new UserDTO(record);
            userDTOList.add(userDTO);
            userService.saveUser(userDTO);
            count++;
        }

        // System.out.println("CSV 데이터 처리 완료! 처리된 건수: " + userDTOList.size() + "개 (최대
        // 5개)");
        // System.out.println("UserController에서 CSV 데이터 처리가 완료되었습니다.");

        return userDTOList;
    }

}
