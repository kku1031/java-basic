package store.kanggyeonggu.api.user.repository;

import org.springframework.stereotype.Repository;

import store.kanggyeonggu.api.user.domain.UserDTO;

@Repository
public class UserRepository {

<<<<<<< HEAD
    // UserDTO 데이터 저장
    public void save(UserDTO userDTO) {

        System.out.println("passengerId : " + userDTO.getPassengerId());
        System.out.println("survived : " + userDTO.getSurvived());
        System.out.println("pclass : " + userDTO.getPclass());
        System.out.println("name : " + userDTO.getName());
        System.out.println("sex : " + userDTO.getSex());
        System.out.println("age : " + userDTO.getAge());
        System.out.println("sibSp : " + userDTO.getSibSp());
        System.out.println("parch : " + userDTO.getParch());
        System.out.println("ticket : " + userDTO.getTicket());
        System.out.println("fare : " + userDTO.getFare());
        System.out.println("cabin : " + userDTO.getCabin());
        System.out.println("embarked : " + userDTO.getEmbarked());
    }
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
}
