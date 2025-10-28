package store.kanggyeonggu.api.hr.service;

import java.util.List;

import store.kanggyeonggu.api.common.domain.Messenger;
import store.kanggyeonggu.api.hr.domain.HRDTO;

public interface HRService {

    Messenger save(HRDTO hr);

    Messenger saveAll(List<HRDTO> hrs);

    Messenger update(HRDTO hr);

    Messenger delete(String id);

    Messenger findById(String id);

    Messenger findAll();

    List<HRDTO> getAllSavedHRs();
}
