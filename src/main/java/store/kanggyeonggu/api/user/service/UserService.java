package store.kanggyeonggu.api.user.service;

import store.kanggyeonggu.api.common.domain.Messenger;
import store.kanggyeonggu.api.user.domain.UserDTO;

public interface UserService {

    Messenger save(UserDTO userDTO);

    Messenger update(UserDTO userDTO);

    Messenger delete(UserDTO userDTO);

    Messenger findById(UserDTO userDTO);

    Messenger findAll(UserDTO userDTO);

}
