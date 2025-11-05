package store.kanggyeonggu.api.pickpro.service;

import java.util.List;

import store.kanggyeonggu.api.common.domain.Messenger;
import store.kanggyeonggu.api.pickpro.domain.PickproDTO;

public interface PickproService {

    Messenger save(PickproDTO pickpro);

    Messenger saveAll(List<PickproDTO> pickpros);

    Messenger update(PickproDTO pickpro);

    Messenger delete(String id);

    Messenger findById(String id);

    Messenger findAll();

    // 저장된 데이터를 직접 반환하는 메소드
    List<PickproDTO> getAllSavedPickpros();
}

