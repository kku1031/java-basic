package store.kanggyeonggu.api.weather.service;

import java.util.List;

import store.kanggyeonggu.api.common.domain.Messenger;
import store.kanggyeonggu.api.weather.domain.WeatherDTO;

public interface WeatherService {

    Messenger save(WeatherDTO weather);

    Messenger saveAll(List<WeatherDTO> weathers);

    Messenger update(WeatherDTO weather);

    Messenger delete(String id);

    Messenger findById(String id);

    Messenger findAll();

    // 저장된 데이터를 직접 반환하는 메소드
    List<WeatherDTO> getAllSavedWeathers();
}
