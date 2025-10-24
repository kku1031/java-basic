package store.kanggyeonggu.api.user.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import store.kanggyeonggu.api.common.domain.Messenger;
import store.kanggyeonggu.api.user.domain.UserDTO;

@Repository
public class UserRepository {

<<<<<<< HEAD
<<<<<<< HEAD
    // UserDTO 데이터 저장
    public void save(UserDTO userDTO) {
=======
    // 실제 데이터를 저장할 리스트
    private List<UserDTO> savedUsers = new ArrayList<>();
>>>>>>> 499b9fd (강사님꺼에 맞게 CRUD 구조화)

    // 저장된 데이터를 직접 반환하는 메소드
    public List<UserDTO> getAllSavedUsers() {
        return new ArrayList<>(savedUsers); // 복사본 반환
    }
<<<<<<< HEAD
=======
    public void save(UserDTO userDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    public void update(UserDTO userDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public void delete(UserDTO userDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public void findById(UserDTO userDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    public void findAll(UserDTO userDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

>>>>>>> ad733d3 (집에서 테스트)
=======

    public Messenger save(UserDTO user) {
        // 실제 데이터 저장
        savedUsers.add(user);

        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("DB에 사용자 데이터가 저장되었습니다.");
        return messenger;
    }

    public Messenger saveAll(List<UserDTO> users) {
        // 실제 데이터 저장
        savedUsers.addAll(users);

        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("DB에 " + users.size() + "개의 사용자 데이터가 저장되었습니다.");
        return messenger;
    }

    public Messenger update(UserDTO user) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("DB에 사용자 데이터가 수정되었습니다.");
        return messenger;
    }

    public Messenger delete(String id) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("DB에 사용자 데이터가 삭제되었습니다.");
        return messenger;
    }

    public Messenger findById(String id) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("DB에서 사용자 데이터가 조회되었습니다.");
        return messenger;
    }

    public Messenger findAll() {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("DB에서 모든 사용자 데이터가 조회되었습니다. (총 " + savedUsers.size() + "개)");
        return messenger;
    }

>>>>>>> 499b9fd (강사님꺼에 맞게 CRUD 구조화)
}
