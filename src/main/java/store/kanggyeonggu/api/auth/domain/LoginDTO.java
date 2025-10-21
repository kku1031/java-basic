package store.kanggyeonggu.api.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//public 택배 상자에서 택배 상자는 누구나 볼수 있지만 안에 있는건 못보게 private으로 걸어둠
@Data // getter, setter, toString, equals, hashCode 메서드 자동 생성
@NoArgsConstructor // 기본 생성자 자동 생성
@AllArgsConstructor
public class LoginDTO {

    // 누구나 내용을 볼 수 있는 상태(따라서 방지 하지 위해서 private)
    private String name;
    private String password; // ->속성과 기능이 있어야 하는데 기능이 없으니까 에러가 남.

}
