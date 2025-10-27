package store.kanggyeonggu.api.weather.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import store.kanggyeonggu.api.common.domain.Messenger;
import store.kanggyeonggu.api.weather.domain.WeatherDTO;
import store.kanggyeonggu.api.weather.repository.WeatherRepository;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository weatherRepository;

    @Override
    public Messenger save(WeatherDTO weather) {
        return weatherRepository.save(weather);
    }

    @Override
    public Messenger saveAll(List<WeatherDTO> weathers) {
        return weatherRepository.saveAll(weathers);
    }

    @Override
    public Messenger update(WeatherDTO weather) {
        return weatherRepository.update(weather);
    }

    @Override
    public Messenger delete(String id) {
        return weatherRepository.delete(id);
    }

    @Override
    public Messenger findById(String id) {

        return weatherRepository.findById(id);
    }

    @Override
    public Messenger findAll() {
        return weatherRepository.findAll();
    }

    @Override
    public List<WeatherDTO> getAllSavedWeathers() {
        return weatherRepository.getAllSavedWeathers();
    }

}
