package store.kanggyeonggu.api.user.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import store.kanggyeonggu.api.common.domain.Messenger;
import store.kanggyeonggu.api.user.domain.UserDTO;
import store.kanggyeonggu.api.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Messenger save(UserDTO userDTO) {
        userRepository.save(userDTO);
        return new Messenger();
    }

    @Override
    public Messenger update(UserDTO userDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Messenger delete(UserDTO userDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Messenger findById(UserDTO userDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Messenger findAll(UserDTO userDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
}
