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
<<<<<<< HEAD
import org.springframework.core.io.ClassPathResource;
<<<<<<< HEAD
=======
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
>>>>>>> 499b9fd (강사님꺼에 맞게 CRUD 구조화)
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
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
=======
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
>>>>>>> 499b9fd (강사님꺼에 맞게 CRUD 구조화)

import lombok.RequiredArgsConstructor;
import store.kanggyeonggu.api.common.domain.Messenger;
import store.kanggyeonggu.api.weather.domain.WeatherDTO;
import store.kanggyeonggu.api.weather.service.WeatherService;

<<<<<<< HEAD
<<<<<<< HEAD
@RestController
=======
@Controller
>>>>>>> ad733d3 (집에서 테스트)
=======
@Controller
>>>>>>> 499b9fd (강사님꺼에 맞게 CRUD 구조화)
@RequiredArgsConstructor
@RequestMapping("/weathers")
public class WeatherController {

    private final WeatherService weatherService;

<<<<<<< HEAD
<<<<<<< HEAD
    @PostMapping("/all")
    public List<WeatherDTO> processAllCsvData() throws Exception {
        ClassPathResource resource = new ClassPathResource("static/csv/TEST_weather_00.csv-Grid view.csv");

        // 🔹 CSV 내용 전체를 읽어서 BOM 제거
=======
    // 업로드된 CSV 파일을 파싱하여 WeatherDTO 리스트로 변환
    private List<WeatherDTO> parseCsvFile(MultipartFile file) throws Exception {
>>>>>>> 499b9fd (강사님꺼에 맞게 CRUD 구조화)
        String content;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
            content = reader.lines()
                    .collect(Collectors.joining("\n"))
                    .replace("\uFEFF", ""); // BOM 제거
        }

        return parseCsvContent(content);
    }

    // 기본 CSV 파일을 파싱하여 WeatherDTO 리스트로 변환
    private List<WeatherDTO> parseDefaultCsvFile() throws Exception {
        String content;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new java.io.FileInputStream("src/main/resources/static/csv/weather.csv"),
                        StandardCharsets.UTF_8))) {
            content = reader.lines()
                    .collect(Collectors.joining("\n"))
                    .replace("\uFEFF", ""); // BOM 제거
        }

<<<<<<< HEAD
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
=======
        return parseCsvContent(content);
    }

    // CSV 내용을 파싱하여 WeatherDTO 리스트로 변환 (공통 로직)
    private List<WeatherDTO> parseCsvContent(String content) throws Exception {
        CSVParser parser = CSVParser.parse(
                content,
                CSVFormat.Builder.create()
                        .setHeader()
                        .setTrim(true)
                        .build());

        List<WeatherDTO> weatherList = new ArrayList<>();
        for (CSVRecord record : parser) {
            WeatherDTO weatherDTO = new WeatherDTO();
            weatherDTO.setDateTime(record.get("일시"));
            weatherDTO.setAvgTemperature(record.get("평균기온(℃)"));
            weatherDTO.setMaxTemperature(record.get("최고기온(℃)"));
            weatherDTO.setMaxTempTime(record.get("최고기온시각"));
            weatherDTO.setMinTemperature(record.get("최저기온(℃)"));
            weatherDTO.setMinTempTime(record.get("최저기온시각"));
            weatherDTO.setDailyRange(record.get("일교차"));
            weatherDTO.setPrecipitation(record.get("강수량(mm)"));
            weatherList.add(weatherDTO);
        }
        return weatherList;
    }

    @PostMapping("/save")
    public String save(WeatherDTO weather, Model model) {
        Messenger messenger = weatherService.save(weather);
        model.addAttribute("messenger", messenger);
        return "weather/list";
    }

    @PostMapping("/all")
    public String saveAll(@RequestParam("file") MultipartFile file, Model model) {
        Messenger messenger;

        try {
            // 파일 검증
            String originalFilename = file.getOriginalFilename();
            if (file.isEmpty() || originalFilename == null || !originalFilename.toLowerCase().endsWith(".csv")) {
                messenger = new Messenger(500, "CSV 파일만 업로드 가능합니다.");
            } else {
                // Controller에서 CSV 파싱
                List<WeatherDTO> weatherList = parseCsvFile(file);

                // Service는 저장만 담당
                messenger = weatherService.saveAll(weatherList);
                messenger.setMessage("업로드된 파일에서 " + weatherList.size() + "개의 날씨 데이터가 저장되었습니다.");
            }
        } catch (Exception e) {
            messenger = new Messenger(500, "처리 중 오류가 발생했습니다: " + e.getMessage());
        }

        model.addAttribute("messenger", messenger);
        return "weather/list";
    }

    @GetMapping("/all")
    public String findAll(Model model) {
        try {
            // Repository에서 저장된 데이터 조회
            List<WeatherDTO> savedWeathers = weatherService.getAllSavedWeathers();

            if (savedWeathers.isEmpty()) {
                // 저장된 데이터가 없으면 기본 CSV 파일 로드
                List<WeatherDTO> weatherList = parseDefaultCsvFile();

                model.addAttribute("weathers", weatherList);
                Messenger messenger = new Messenger(200, "기본 데이터 " + weatherList.size() + "개가 로드되었습니다. (저장된 데이터 없음)");
                model.addAttribute("messenger", messenger);
            } else {
                // 저장된 데이터가 있으면 저장된 데이터 표시
                model.addAttribute("weathers", savedWeathers);
                Messenger messenger = new Messenger(200, "저장된 데이터 " + savedWeathers.size() + "개가 조회되었습니다.");
                model.addAttribute("messenger", messenger);
            }
        } catch (Exception e) {
            Messenger messenger = new Messenger(500, "데이터 로드 실패: " + e.getMessage());
            model.addAttribute("messenger", messenger);
        }
        return "weather/list";
    }

    @GetMapping("/id/{id}")
    public String findById(@PathVariable String id, Model model) {
        Messenger messenger = weatherService.findById(id);
        model.addAttribute("messenger", messenger);
        return "weather/detail";
    }

    @PutMapping("{id}")
    public String update(WeatherDTO weather, Model model) {
        Messenger messenger = weatherService.update(weather);
        model.addAttribute("messenger", messenger);
        return "weather/detail";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id, Model model) {
        Messenger messenger = weatherService.delete(id);
        model.addAttribute("messenger", messenger);
        return "weather/list";
>>>>>>> 499b9fd (강사님꺼에 맞게 CRUD 구조화)
    }

}
