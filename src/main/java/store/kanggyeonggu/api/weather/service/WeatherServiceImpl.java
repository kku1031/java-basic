package store.kanggyeonggu.api.weather.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import store.kanggyeonggu.api.weather.domain.WeatherDTO;
import store.kanggyeonggu.api.weather.repository.WeatherRepository;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository weatherRepository;

    @Override
    public void saveWeather(WeatherDTO weatherDTO) {
        weatherRepository.save(weatherDTO);
    }
}
