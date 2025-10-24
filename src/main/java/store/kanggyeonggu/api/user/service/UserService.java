package store.kanggyeonggu.api.user.service;

import java.util.List;

import store.kanggyeonggu.api.common.domain.Messenger;
import store.kanggyeonggu.api.user.domain.UserDTO;

public interface UserService {

    Messenger save(UserDTO user);

    Messenger saveAll(List<UserDTO> users);

    Messenger update(UserDTO user);

    Messenger delete(String id);

    Messenger findById(String id);

    Messenger findAll();

    // 저장된 데이터를 직접 반환하는 메소드
    List<UserDTO> getAllSavedUsers();

}
