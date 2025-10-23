package store.kanggyeonggu.api.user.service;

<<<<<<< HEAD
=======
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;
>>>>>>> ad733d3 (집에서 테스트)
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
<<<<<<< HEAD
=======
   

>>>>>>> ad733d3 (집에서 테스트)
}
