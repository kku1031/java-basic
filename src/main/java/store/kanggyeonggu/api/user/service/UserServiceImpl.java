package store.kanggyeonggu.api.user.service;

<<<<<<< HEAD
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
=======
import java.util.List;

>>>>>>> 499b9fd (강사님꺼에 맞게 CRUD 구조화)
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
   

>>>>>>> ad733d3 (집에서 테스트)
=======

    @Override
    public Messenger findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<UserDTO> getAllSavedUsers() {
        return userRepository.getAllSavedUsers();
    }

>>>>>>> 499b9fd (강사님꺼에 맞게 CRUD 구조화)
}
