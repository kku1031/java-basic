package store.kanggyeonggu.api.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;

@Controller
public class RegisterController {

    @GetMapping("auth/register")
    @ResponseBody
    public List<Map<String, String>> showTopFiveFromCsv() throws Exception {
        ClassPathResource resource = new ClassPathResource("static/csv/train.csv");
        List<Map<String, String>> rows = new ArrayList<>();
        try (Reader reader = new InputStreamReader(resource.getInputStream());
                CSVParser parser = CSVFormat.DEFAULT
                        .withFirstRecordAsHeader()
                        .withTrim()
                        .parse(reader)) {
            int count = 0;
            for (CSVRecord record : parser) {
                Map<String, String> row = new LinkedHashMap<>();
                row.put("PassengerId", record.get("PassengerId"));
                row.put("Name", record.get("Name"));
                row.put("Sex", record.get("Sex"));
                row.put("Age", record.get("Age"));
                row.put("Survived", record.get("Survived"));
                rows.add(row);
                count++;
                if (count >= 5)
                    break;
            }
        }
        return rows;
    }
}
