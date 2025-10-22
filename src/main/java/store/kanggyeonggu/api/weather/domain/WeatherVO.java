package store.kanggyeonggu.api.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherVO {

    private String dateTime;
    private String avgTemperature;
    private String maxTemperature;
    private String maxTempTime;
    private String minTemperature;
    private String minTempTime;
    private String dailyRange;
    private String precipitation;

}
