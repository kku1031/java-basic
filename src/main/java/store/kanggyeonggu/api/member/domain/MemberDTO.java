package store.kanggyeonggu.api.member.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter, setter, toString, equals, hashCode 메서드 자동 생성
@NoArgsConstructor // 기본 생성자 자동 생성
@AllArgsConstructor
public class MemberDTO {

    private String memberId;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String joinDate;
    private String status;

}