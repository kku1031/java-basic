package store.kanggyeonggu.api.user.domain;

import lombok.Data;

@Data
public class UserEntity {

    private String passengerId;
    private String survived;
    private String pclass;
    private String name;
    private String sex;
    private String age;
    private String sibSp;
    private String parch;
    private String ticket;
    private String fare;
    private String cabin;
    private String embarked;

}
