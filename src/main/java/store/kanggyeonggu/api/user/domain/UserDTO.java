package store.kanggyeonggu.api.user.domain;

import org.apache.commons.csv.CSVRecord;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter, setter, toString, equals, hashCode 메서드 자동 생성
@NoArgsConstructor // 기본 생성자 자동 생성
@AllArgsConstructor
public class UserDTO {

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

    // CSV Record를 받는 생성자
    public UserDTO(CSVRecord record) {
        this.passengerId = record.get("PassengerId");
        this.survived = record.get("Survived");
        this.pclass = record.get("Pclass");
        this.name = record.get("Name");
        this.sex = record.get("Sex");
        this.age = record.get("Age");
        this.sibSp = record.get("SibSp");
        this.parch = record.get("Parch");
        this.ticket = record.get("Ticket");
        this.fare = record.get("Fare");
        this.cabin = record.get("Cabin");
        this.embarked = record.get("Embarked");
    }

}
