package store.kanggyeonggu.api.pickpro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import store.kanggyeonggu.api.common.domain.Messenger;
import store.kanggyeonggu.api.pickpro.domain.PickproDTO;
import store.kanggyeonggu.api.pickpro.repository.PickproRepository;

@Service
@RequiredArgsConstructor
public class PickproServiceImpl implements PickproService {

    private final PickproRepository pickproRepository;

    @Override
    public Messenger save(PickproDTO pickpro) {
        return pickproRepository.save(pickpro);
    }

    @Override
    public Messenger saveAll(List<PickproDTO> pickpros) {
        return pickproRepository.saveAll(pickpros);
    }

    @Override
    public Messenger update(PickproDTO pickpro) {
        return pickproRepository.update(pickpro);
    }

    @Override
    public Messenger delete(String id) {
        return pickproRepository.delete(id);
    }

    @Override
    public Messenger findById(String id) {
        return pickproRepository.findById(id);
    }

    @Override
    public Messenger findAll() {
        return pickproRepository.findAll();
    }

    @Override
    public List<PickproDTO> getAllSavedPickpros() {
        return pickproRepository.getAllSavedPickpros();
    }

}

