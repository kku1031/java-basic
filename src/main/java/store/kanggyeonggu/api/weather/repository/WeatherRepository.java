package store.kanggyeonggu.api.weather.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import store.kanggyeonggu.api.common.domain.Messenger;
import store.kanggyeonggu.api.weather.domain.WeatherDTO;

@Repository
public class WeatherRepository {

    // 실제 데이터를 저장할 리스트
    private List<WeatherDTO> savedWeathers = new ArrayList<>();

    // 저장된 데이터를 직접 반환하는 메소드
    public List<WeatherDTO> getAllSavedWeathers() {
        return new ArrayList<>(savedWeathers); // 복사본 반환
    }

    public Messenger save(WeatherDTO weather) {
        // 실제 데이터 저장
        savedWeathers.add(weather);

        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("DB에 날씨 데이터가 저장되었습니다.");
        return messenger;
    }

    public Messenger saveAll(List<WeatherDTO> weathers) {
        // 실제 데이터 저장
        savedWeathers.addAll(weathers);

        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("DB에 " + weathers.size() + "개의 날씨 데이터가 저장되었습니다.");
        return messenger;
    }

    public Messenger update(WeatherDTO weather) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("DB에 날씨 데이터가 수정되었습니다.");
        return messenger;
    }

    public Messenger delete(String id) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("DB에 날씨 데이터가 삭제되었습니다.");
        return messenger;
    }

    public Messenger findById(String id) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("DB에서 날씨 데이터가 조회되었습니다.");
        return messenger;
    }

    public Messenger findAll() {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("DB에서 모든 날씨 데이터가 조회되었습니다. (총 " + savedWeathers.size() + "개)");
        return messenger;
    }

}
