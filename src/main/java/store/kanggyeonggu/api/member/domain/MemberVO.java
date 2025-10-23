package store.kanggyeonggu.api.member.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {

    private String memberId;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String joinDate;
    private String status;

}
