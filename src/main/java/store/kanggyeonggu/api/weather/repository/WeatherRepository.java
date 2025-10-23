package store.kanggyeonggu.api.weather.repository;

import org.springframework.stereotype.Repository;

import store.kanggyeonggu.api.weather.domain.WeatherDTO;

@Repository
public class WeatherRepository {

    public void save(WeatherDTO weatherDTO) {
<<<<<<< HEAD
        System.out.println("일시 : " + weatherDTO.getDateTime());
        System.out.println("평균기온 : " + weatherDTO.getAvgTemperature());
        System.out.println("최고기온 : " + weatherDTO.getMaxTemperature());
        System.out.println("최고기온시각 : " + weatherDTO.getMaxTempTime());
        System.out.println("최저기온 : " + weatherDTO.getMinTemperature());
        System.out.println("최저기온시각 : " + weatherDTO.getMinTempTime());
        System.out.println("일교차 : " + weatherDTO.getDailyRange());
        System.out.println("강수량 : " + weatherDTO.getPrecipitation());
    }
=======
      
    }

    public void update(WeatherDTO weatherDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public void delete(WeatherDTO weatherDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public void findById(WeatherDTO weatherDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    public void findAll(WeatherDTO weatherDTO) {
        System.out.println("일시 : " + weatherDTO.getDateTime());
        System.out.println("평균기온(℃) : " + weatherDTO.getAvgTemperature());
        System.out.println("최고기온(℃) : " + weatherDTO.getMaxTemperature());
        System.out.println("최고기온시각 : " + weatherDTO.getMaxTempTime());
        System.out.println("최저기온(℃) : " + weatherDTO.getMinTemperature());
        System.out.println("최저기온시각 : " + weatherDTO.getMinTempTime());
        System.out.println("일교차 : " + weatherDTO.getDailyRange());
        System.out.println("강수량(mm) : " + weatherDTO.getPrecipitation());
    }

>>>>>>> ad733d3 (집에서 테스트)
}
