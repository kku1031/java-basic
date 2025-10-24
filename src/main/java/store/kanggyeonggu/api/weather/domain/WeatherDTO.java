package store.kanggyeonggu.api.weather.domain;

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

}
