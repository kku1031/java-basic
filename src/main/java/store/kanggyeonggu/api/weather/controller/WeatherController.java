package store.kanggyeonggu.api.weather.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
=======
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> ad733d3 (집에서 테스트)

import lombok.RequiredArgsConstructor;
import store.kanggyeonggu.api.weather.domain.WeatherDTO;
import store.kanggyeonggu.api.weather.service.WeatherService;

<<<<<<< HEAD
@RestController
=======
@Controller
>>>>>>> ad733d3 (집에서 테스트)
@RequiredArgsConstructor
@RequestMapping("/weathers")
public class WeatherController {

    private final WeatherService weatherService;

<<<<<<< HEAD
    @PostMapping("/all")
    public List<WeatherDTO> processAllCsvData() throws Exception {
        ClassPathResource resource = new ClassPathResource("static/csv/TEST_weather_00.csv-Grid view.csv");

        // 🔹 CSV 내용 전체를 읽어서 BOM 제거
        String content;
        // BufferedReader 로 CSV 파일을 UTF-8로 읽음
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
            content = reader.lines() // 모든 줄을 Stream 형태로 가져옴
                    .collect(Collectors.joining("\n"))
                    .replace("\uFEFF", ""); // BOM 제거
        }

        // 🔹 CSV 파싱
        CSVParser parser = CSVParser.parse(
                content,
                CSVFormat.DEFAULT
                        .withFirstRecordAsHeader()
                        .withTrim());

        List<WeatherDTO> weatherDTOList = new ArrayList<>();
        for (CSVRecord record : parser) {
            WeatherDTO weatherDTO = new WeatherDTO(record);
            weatherDTOList.add(weatherDTO);

            // 각 WeatherDTO를 저장하여 Repository의 save 메서드 호출
            weatherService.saveWeather(weatherDTO);
        }

        return weatherDTOList;
=======
    @PostMapping("") // get쓰면 파일 업로드가 안됨 - 등록은 하나 밖에 없으니까 디폴트 만 던짐(주소값 안넣고)
    public void save(@RequestBody WeatherDTO weatherDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @PutMapping("/{id}")
    public void update(@RequestBody WeatherDTO weatherDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @GetMapping("/id/{id}")
    public void findById(@PathVariable String id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @GetMapping("/all")
    public String findAll(WeatherDTO weatherDTO, Model model) {
        try {
            ClassPathResource resource = new ClassPathResource("static/csv/TEST_weather_00.csv-Grid view.csv");

            // 🔹 CSV 내용 전체를 읽어서 BOM 제거
            String content;
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
                content = reader.lines()
                        .collect(Collectors.joining("\n"))
                        .replace("\uFEFF", ""); // BOM 제거
            }

            // 🔹 CSV 파싱
            CSVParser parser = CSVParser.parse(
                    content,
                    CSVFormat.DEFAULT
                            .withFirstRecordAsHeader()
                            .withTrim());

            List<WeatherDTO> weatherDTOList = new ArrayList<>();
            int count = 0;
            for (CSVRecord record : parser) {
                if (count >= 5) break; // 상위 5개만 처리
                WeatherDTO dto = new WeatherDTO(record);
                weatherDTOList.add(dto);
                count++;
            }

            // Controller에서 반복문으로 Repository 호출
            System.out.println("[WEATHER FINDALL] Loaded weather data (top " + weatherDTOList.size() + ")");
            for (WeatherDTO w : weatherDTOList) {
                weatherService.findAll(w); // Repository의 findAll 호출하여 출력
                System.out.println("----------------------------------------");
            }
            
            // Model에 데이터 추가
            model.addAttribute("weathers", weatherDTOList);
            model.addAttribute("message", "Weather 데이터를 성공적으로 불러왔습니다.");
            return "weather/list";

        } catch (Exception e) {
            System.out.println("Weather 데이터 로딩 실패: " + e.getMessage());
            e.printStackTrace();
            model.addAttribute("error", "데이터 로딩 실패: " + e.getMessage());
            return "weather/list";
        }
>>>>>>> ad733d3 (집에서 테스트)
    }

}
