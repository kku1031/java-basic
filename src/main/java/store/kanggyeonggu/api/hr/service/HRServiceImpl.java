package store.kanggyeonggu.api.hr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import store.kanggyeonggu.api.common.domain.Messenger;
import store.kanggyeonggu.api.hr.domain.HRDTO;
import store.kanggyeonggu.api.hr.repository.HRRepository;

@Service
@RequiredArgsConstructor
public class HRServiceImpl implements HRService {

    private final HRRepository hrRepository;

    @Override
    public Messenger save(HRDTO hr) {
        return hrRepository.save(hr);
    }

    @Override
    public Messenger saveAll(List<HRDTO> hrs) {
        return hrRepository.saveAll(hrs);
    }

    @Override
    public Messenger update(HRDTO hr) {
        return hrRepository.update(hr);
    }

    @Override
    public Messenger delete(String id) {
        return hrRepository.delete(id);
    }

    @Override
    public Messenger findById(String id) {
        return hrRepository.findById(id);
    }

    @Override
    public Messenger findAll() {
        return hrRepository.findAll();
    }

    @Override
    public List<HRDTO> getAllSavedHRs() {
        return hrRepository.getAllSavedHRs();
    }

}
