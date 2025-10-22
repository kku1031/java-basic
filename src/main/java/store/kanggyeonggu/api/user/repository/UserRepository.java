package store.kanggyeonggu.api.user.repository;

import org.springframework.stereotype.Repository;

import store.kanggyeonggu.api.user.domain.UserDTO;

@Repository
public class UserRepository {

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
}
