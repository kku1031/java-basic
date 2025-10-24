package store.kanggyeonggu.api.weather.service;

import java.util.List;

import store.kanggyeonggu.api.common.domain.Messenger;
import store.kanggyeonggu.api.weather.domain.WeatherDTO;

public interface WeatherService {

<<<<<<< HEAD
    public void saveWeather(WeatherDTO weatherDTO);
<<<<<<< HEAD
=======

    public void updateWeather(WeatherDTO weatherDTO);

    public void deleteWeather(WeatherDTO weatherDTO);

    public void findById(WeatherDTO weatherDTO);

    public void findAll(WeatherDTO weatherDTO);

>>>>>>> ad733d3 (집에서 테스트)
=======
    Messenger save(WeatherDTO weather);

    Messenger saveAll(List<WeatherDTO> weathers);

    Messenger update(WeatherDTO weather);

    Messenger delete(String id);

    Messenger findById(String id);

    Messenger findAll();

    // 저장된 데이터를 직접 반환하는 메소드
    List<WeatherDTO> getAllSavedWeathers();

>>>>>>> 499b9fd (강사님꺼에 맞게 CRUD 구조화)
}
