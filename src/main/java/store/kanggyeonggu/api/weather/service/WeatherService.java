package store.kanggyeonggu.api.weather.service;

import store.kanggyeonggu.api.weather.domain.WeatherDTO;

public interface WeatherService {

    public void saveWeather(WeatherDTO weatherDTO);
}
