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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import store.kanggyeonggu.api.weather.domain.WeatherDTO;
import store.kanggyeonggu.api.weather.service.WeatherService;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("auth/weather")
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
    }

}
