package store.kanggyeonggu.api.hr.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import store.kanggyeonggu.api.common.domain.Messenger;
import store.kanggyeonggu.api.hr.domain.HRDTO;

@Repository
public class HRRepository {

    private List<HRDTO> savedHRs = new ArrayList<>();

    public List<HRDTO> getAllSavedHRs() {
        return new ArrayList<>(savedHRs);
    }

    public Messenger save(HRDTO hr) {
        // 실제 데이터 저장
        savedHRs.add(hr);

        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("DB에 HR 데이터가 저장되었습니다.");
        return messenger;
    }

    public Messenger saveAll(List<HRDTO> hrs) {
        // 실제 데이터 저장
        savedHRs.addAll(hrs);

        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("DB에 " + hrs.size() + "개의 HR 데이터가 저장되었습니다.");
        return messenger;
    }

    public Messenger update(HRDTO hr) {
        Messenger messenger = new Messenger();
        return messenger;
    }

    public Messenger delete(String id) {
        Messenger messenger = new Messenger();
        return messenger;
    }

    public Messenger findById(String id) {
        Messenger messenger = new Messenger();
        return messenger;
    }

    public Messenger findAll() {
        Messenger messenger = new Messenger();
        return messenger;
    }

}
