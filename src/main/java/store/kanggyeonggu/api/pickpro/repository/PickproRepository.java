package store.kanggyeonggu.api.pickpro.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import store.kanggyeonggu.api.common.domain.Messenger;
import store.kanggyeonggu.api.pickpro.domain.PickproDTO;

@Repository
public class PickproRepository {

    private List<PickproDTO> savedPickpros = new ArrayList<>();

    public List<PickproDTO> getAllSavedPickpros() {
        return new ArrayList<>(savedPickpros);
    }

    public Messenger save(PickproDTO pickpro) {
        savedPickpros.add(pickpro);
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("DB에 pickpro 데이터가 저장되었습니다.");
        return messenger;
    }

    public Messenger saveAll(List<PickproDTO> pickpros) {
        savedPickpros.addAll(pickpros);
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("DB에 " + pickpros.size() + "개의 pickpro 데이터가 저장되었습니다.");
        return messenger;
    }

    public Messenger update(PickproDTO pickpro) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("DB에 pickpro 데이터가 수정되었습니다.");
        return messenger;
    }

    public Messenger delete(String id) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("DB에 pickpro 데이터가 삭제되었습니다.");
        return messenger;
    }

    public Messenger findById(String id) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("DB에서 pickpro 데이터가 조회되었습니다.");
        return messenger;
    }

    public Messenger findAll() {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("DB에서 모든 pickpro 데이터가 조회되었습니다. (총 " + savedPickpros.size() + "개)");
        return messenger;
    }

}
