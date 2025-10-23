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
<<<<<<< HEAD
=======

    @Override
    public void findAll(WeatherDTO weatherDTO) {
        weatherRepository.findAll(weatherDTO);
    }

    @Override
    public void updateWeather(WeatherDTO weatherDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateWeather'");
    }

    @Override
    public void deleteWeather(WeatherDTO weatherDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteWeather'");
    }

    @Override
    public void findById(WeatherDTO weatherDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
>>>>>>> ad733d3 (집에서 테스트)
}
