package store.kanggyeonggu.api.weather.domain;

import lombok.Data;

@Data
public class WeatherEntity {

    private String dateTime;
    private String avgTemperature;
    private String maxTemperature;
    private String maxTempTime;
    private String minTemperature;
    private String minTempTime;
    private String dailyRange;
    private String precipitation;

}
