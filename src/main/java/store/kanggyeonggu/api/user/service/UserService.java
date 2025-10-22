package store.kanggyeonggu.api.user.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import store.kanggyeonggu.api.user.domain.UserDTO;
import store.kanggyeonggu.api.user.repository.UserRepository;

@Service
@RequiredArgsConstructor // 필드만 받는 생성자를 만들어줌
public class UserService {

    private final UserRepository userRepository;

    public void saveUser(UserDTO userDTO) {
        userRepository.save(userDTO);
    }
}
