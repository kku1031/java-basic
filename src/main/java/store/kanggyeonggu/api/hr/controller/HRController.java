package store.kanggyeonggu.api.hr.controller;

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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import store.kanggyeonggu.api.common.domain.Messenger;
import store.kanggyeonggu.api.hr.domain.HRDTO;
import store.kanggyeonggu.api.hr.service.HRService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/hrs")
public class HRController {

    private final HRService hrService;

    // 업로드된 CSV 파일을 파싱하여 HRDTO 리스트로 변환
    private List<HRDTO> parseCsvFile(MultipartFile file) throws Exception {
        String content;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
            content = reader.lines()
                    .collect(Collectors.joining("\n"))
                    .replace("\uFEFF", ""); // BOM 제거
        }

        return parseCsvContent(content);
    }

    // 기본 CSV 파일을 파싱하여 HRDTO 리스트로 변환
    private List<HRDTO> parseDefaultCsvFile() throws Exception {
        String content;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new java.io.FileInputStream("src/main/resources/static/csv/HR.csv"),
                        StandardCharsets.UTF_8))) {
            content = reader.lines()
                    .collect(Collectors.joining("\n"))
                    .replace("\uFEFF", ""); // BOM 제거
        }

        return parseCsvContent(content);
    }

    // CSV 내용을 파싱하여 HRDTO 리스트로 변환 (공통 로직)
    private List<HRDTO> parseCsvContent(String content) throws Exception {
        CSVParser parser = CSVParser.parse(
                content,
                CSVFormat.Builder.create()
                        .setHeader()
                        .setTrim(true)
                        .build());

        List<HRDTO> hrList = new ArrayList<>();
        for (CSVRecord record : parser) {
            HRDTO hrDTO = new HRDTO();
            hrDTO.setAge(record.get("Age"));
            hrDTO.setAttrition(record.get("Attrition"));
            hrDTO.setBusinessTravel(record.get("BusinessTravel"));
            hrDTO.setDailyRate(record.get("DailyRate"));
            hrDTO.setDepartment(record.get("Department"));
            hrDTO.setDistanceFromHome(record.get("DistanceFromHome"));
            hrDTO.setEducation(record.get("Education"));
            hrDTO.setEducationField(record.get("EducationField"));
            hrDTO.setEmployeeCount(record.get("EmployeeCount"));
            hrDTO.setEmployeeNumber(record.get("EmployeeNumber"));
            hrDTO.setEnvironmentSatisfaction(record.get("EnvironmentSatisfaction"));
            hrDTO.setGender(record.get("Gender"));
            hrDTO.setHourlyRate(record.get("HourlyRate"));
            hrDTO.setJobInvolvement(record.get("JobInvolvement"));
            hrDTO.setJobLevel(record.get("JobLevel"));
            hrDTO.setJobRole(record.get("JobRole"));
            hrDTO.setJobSatisfaction(record.get("JobSatisfaction"));
            hrDTO.setMaritalStatus(record.get("MaritalStatus"));
            hrDTO.setMonthlyIncome(record.get("MonthlyIncome"));
            hrDTO.setMonthlyRate(record.get("MonthlyRate"));
            hrDTO.setNumCompaniesWorked(record.get("NumCompaniesWorked"));
            hrDTO.setOver18(record.get("Over18"));
            hrDTO.setOverTime(record.get("OverTime"));
            hrDTO.setPercentSalaryHike(record.get("PercentSalaryHike"));
            hrDTO.setPerformanceRating(record.get("PerformanceRating"));
            hrDTO.setRelationshipSatisfaction(record.get("RelationshipSatisfaction"));
            hrDTO.setStandardHours(record.get("StandardHours"));
            hrDTO.setStockOptionLevel(record.get("StockOptionLevel"));
            hrDTO.setTotalWorkingYears(record.get("TotalWorkingYears"));
            hrDTO.setTrainingTimesLastYear(record.get("TrainingTimesLastYear"));
            hrDTO.setWorkLifeBalance(record.get("WorkLifeBalance"));
            hrDTO.setYearsAtCompany(record.get("YearsAtCompany"));
            hrDTO.setYearsInCurrentRole(record.get("YearsInCurrentRole"));
            hrDTO.setYearsSinceLastPromotion(record.get("YearsSinceLastPromotion"));
            hrDTO.setYearsWithCurrManager(record.get("YearsWithCurrManager"));
            hrList.add(hrDTO);
        }
        return hrList;
    }

    @PostMapping("/save")
    public String save(HRDTO hr, Model model) {
        Messenger messenger = hrService.save(hr);
        model.addAttribute("messenger", messenger);
        return "hr/list";
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
                List<HRDTO> hrList = parseCsvFile(file);

                // Service는 저장만 담당
                messenger = hrService.saveAll(hrList);
                messenger.setMessage("업로드된 파일에서 " + hrList.size() + "개의 HR 데이터가 저장되었습니다.");
            }
        } catch (Exception e) {
            messenger = new Messenger(500, "처리 중 오류가 발생했습니다: " + e.getMessage());
        }

        model.addAttribute("messenger", messenger);
        return "hr/list";
    }

    @GetMapping("/all")
    public String findAll(Model model) {
        try {
            // Repository에서 저장된 데이터 조회
            List<HRDTO> savedHRs = hrService.getAllSavedHRs();

            if (savedHRs.isEmpty()) {
                // 저장된 데이터가 없으면 기본 CSV 파일 로드
                List<HRDTO> hrList = parseDefaultCsvFile();

                model.addAttribute("hrs", hrList);
                Messenger messenger = new Messenger(200, "기본 데이터 " + hrList.size() + "개가 로드되었습니다. (저장된 데이터 없음)");
                model.addAttribute("messenger", messenger);
            } else {
                // 저장된 데이터가 있으면 저장된 데이터 표시
                model.addAttribute("hrs", savedHRs);
                Messenger messenger = new Messenger(200, "저장된 데이터 " + savedHRs.size() + "개가 조회되었습니다.");
                model.addAttribute("messenger", messenger);
            }
        } catch (Exception e) {
            Messenger messenger = new Messenger(500, "데이터 로드 실패: " + e.getMessage());
            model.addAttribute("messenger", messenger);
        }
        return "hr/list";
    }

    @GetMapping("/id/{id}")
    public String findById(@PathVariable String id, Model model) {
        Messenger messenger = hrService.findById(id);
        model.addAttribute("messenger", messenger);
        return "hr/detail";
    }

    @PutMapping("{id}")
    public String update(HRDTO hr, Model model) {
        Messenger messenger = hrService.update(hr);
        model.addAttribute("messenger", messenger);
        return "hr/detail";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id, Model model) {
        Messenger messenger = hrService.delete(id);
        model.addAttribute("messenger", messenger);
        return "hr/list";
    }

}
