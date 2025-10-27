package store.kanggyeonggu.api.user.service;

import java.util.List;

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
    public Messenger save(UserDTO user) {
        return userRepository.save(user);
    }

    @Override
    public Messenger saveAll(List<UserDTO> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public Messenger update(UserDTO user) {
        return userRepository.update(user);
    }

    @Override
    public Messenger delete(String id) {
        return userRepository.delete(id);
    }

    @Override
    public Messenger findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Messenger findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<UserDTO> getAllSavedUsers() {
        return userRepository.getAllSavedUsers();
    }

}
