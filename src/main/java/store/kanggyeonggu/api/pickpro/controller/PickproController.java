package store.kanggyeonggu.api.pickpro.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import store.kanggyeonggu.api.common.domain.Messenger;
import store.kanggyeonggu.api.pickpro.domain.PickproDTO;
import store.kanggyeonggu.api.pickpro.service.PickproService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pickpros")
public class PickproController {

    private final PickproService pickproService;

    // 업로드된 CSV 파일을 파싱하여 PickproDTO 리스트로 변환
    private List<PickproDTO> parseCsvFile(MultipartFile file) throws Exception {
        String content;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
            content = reader.lines()
                    .collect(Collectors.joining("\n"))
                    .replace("\uFEFF", ""); // BOM 제거
        }

        return parseCsvContent(content);
    }

    // 기본 CSV 파일을 파싱하여 PickproDTO 리스트로 변환
    private List<PickproDTO> parseDefaultCsvFile() throws Exception {
        String content;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new java.io.FileInputStream("src/main/resources/static/csv/org_chart.csv"),
                        StandardCharsets.UTF_8))) {
            content = reader.lines()
                    .collect(Collectors.joining("\n"))
                    .replace("\uFEFF", ""); // BOM 제거
        }

        return parseCsvContent(content);
    }

    // CSV 내용을 파싱하여 PickproDTO 리스트로 변환 (공통 로직)
    private List<PickproDTO> parseCsvContent(String content) throws Exception {
        CSVParser parser = CSVParser.parse(
                content,
                CSVFormat.Builder.create()
                        .setHeader()
                        .setTrim(true)
                        .build());

        List<PickproDTO> pickproList = new ArrayList<>();
        for (CSVRecord record : parser) {
            PickproDTO pickproDTO = new PickproDTO();
            pickproDTO.setIndex(record.get("index"));
            pickproDTO.setParentDepartment(record.get("ParentDepartment"));
            pickproDTO.setDepartment(record.get("Department"));
            pickproDTO.setSubDepartment(record.get("SubDepartment"));
            pickproList.add(pickproDTO);
        }
        return pickproList;
    }

    @PostMapping("/save")
    public String save(PickproDTO pickpro, Model model) {
        Messenger messenger = pickproService.save(pickpro);
        model.addAttribute("messenger", messenger);
        return "pickpro/list";
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
                List<PickproDTO> pickproList = parseCsvFile(file);

                // Service는 저장만 담당
                messenger = pickproService.saveAll(pickproList);
                messenger.setMessage("업로드된 파일에서 " + pickproList.size() + "개의 pickpro 데이터가 저장되었습니다.");
            }
        } catch (Exception e) {
            messenger = new Messenger(500, "처리 중 오류가 발생했습니다: " + e.getMessage());
        }

        model.addAttribute("messenger", messenger);
        return "pickpro/list";
    }

    @GetMapping("/all")
    public String findAll(Model model) {
        try {
            // Repository에서 저장된 데이터 조회
            List<PickproDTO> savedPickpros = pickproService.getAllSavedPickpros();

            if (savedPickpros.isEmpty()) {
                // 저장된 데이터가 없으면 기본 CSV 파일 로드
                List<PickproDTO> pickproList = parseDefaultCsvFile();

                model.addAttribute("pickpros", pickproList);
                Messenger messenger = new Messenger(200, "기본 데이터 " + pickproList.size() + "개가 로드되었습니다. (저장된 데이터 없음)");
                model.addAttribute("messenger", messenger);
            } else {
                // 저장된 데이터가 있으면 저장된 데이터 표시
                model.addAttribute("pickpros", savedPickpros);
                Messenger messenger = new Messenger(200, "저장된 데이터 " + savedPickpros.size() + "개가 조회되었습니다.");
                model.addAttribute("messenger", messenger);
            }
        } catch (Exception e) {
            Messenger messenger = new Messenger(500, "데이터 로드 실패: " + e.getMessage());
            model.addAttribute("messenger", messenger);
        }
        return "pickpro/list";
    }

    @GetMapping("/id/{id}")
    public String findById(@PathVariable String id, Model model) {
        Messenger messenger = pickproService.findById(id);
        model.addAttribute("messenger", messenger);
        return "pickpro/detail";
    }

    @PutMapping("{id}")
    public String update(PickproDTO pickpro, Model model) {
        Messenger messenger = pickproService.update(pickpro);
        model.addAttribute("messenger", messenger);
        return "pickpro/detail";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id, Model model) {
        Messenger messenger = pickproService.delete(id);
        model.addAttribute("messenger", messenger);
        return "pickpro/list";
    }

}
