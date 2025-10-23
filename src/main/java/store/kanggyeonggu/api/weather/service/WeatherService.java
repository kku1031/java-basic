package store.kanggyeonggu.api.weather.service;

import store.kanggyeonggu.api.weather.domain.WeatherDTO;

public interface WeatherService {

    public void saveWeather(WeatherDTO weatherDTO);
<<<<<<< HEAD
=======

    public void updateWeather(WeatherDTO weatherDTO);

    public void deleteWeather(WeatherDTO weatherDTO);

    public void findById(WeatherDTO weatherDTO);

    public void findAll(WeatherDTO weatherDTO);

>>>>>>> ad733d3 (집에서 테스트)
}
