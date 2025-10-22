package store.kanggyeonggu.api.weather.domain;

import org.apache.commons.csv.CSVRecord;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDTO {

    private String dateTime; // 일시
    private String avgTemperature; // 평균기온
    private String maxTemperature; // 최고기온
    private String maxTempTime; // 최고기온시각
    private String minTemperature; // 최저기온
    private String minTempTime; // 최저기온시각
    private String dailyRange; // 일교차
    private String precipitation; // 강수량

    // CSV Record를 받는 생성자
    public WeatherDTO(CSVRecord record) {
        this.dateTime = record.get("일시");
        this.avgTemperature = record.get("평균기온(℃)");
        this.maxTemperature = record.get("최고기온(℃)");
        this.maxTempTime = record.get("최고기온시각");
        this.minTemperature = record.get("최저기온(℃)");
        this.minTempTime = record.get("최저기온시각");
        this.dailyRange = record.get("일교차");
        this.precipitation = record.get("강수량(mm)");
    }
}
