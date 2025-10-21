package store.kanggyeonggu.api.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // 기본 생성자 자동 생성
@AllArgsConstructor
public class LoginVO {
    // 누구나 내용을 볼 수 있는 상태(따라서 방지 하지 위해서 private)
    private String name = "aaa";
    private String password = "bbb"; // ->속성과 기능이 있어야 하는데 기능이 없으니까 에러가 남.
    // / 이거 지우고 위에 써도 됨

}
