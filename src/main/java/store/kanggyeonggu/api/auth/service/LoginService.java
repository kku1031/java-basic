package store.kanggyeonggu.api.auth.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import store.kanggyeonggu.api.auth.domain.LoginDTO;
import store.kanggyeonggu.api.auth.domain.LoginVO;
import store.kanggyeonggu.api.common.domain.Messenger;

@Service
@RequiredArgsConstructor
public class LoginService {
    // 들여쓰기 해야 자식이 됨
    public Messenger login(LoginDTO loginDTO) {
        System.out.println("로그인 서비스로 들어옴");
        System.out.println("DTO로 전달된 이메일 : " + loginDTO.getName());
        System.out.println("DTO로 전달된 비밀번호 : " + loginDTO.getPassword());

        LoginVO loginVO = new LoginVO();

        System.out.println("vo에서 서비스로 전달된 이메일 : " + loginVO.getName());
        System.out.println("vo에서 서비스로 전달된 비밀번호 : " + loginVO.getPassword());

        int code = 0;
        String message = "";

        if (loginVO.getName().equals(loginDTO.getName())
                && loginVO.getPassword().equals(loginDTO.getPassword())) {
            code = 0;
            message = "로그인 성공";
        }
        //// 이메일은 같고 비밀번호만 다를 때 !not연산자
        else if (loginVO.getName().equals(loginDTO.getName())
                && !loginVO.getPassword().equals(loginDTO.getPassword())) {
            code = 2;
            message = "비밀번호 불일치";
        } else {
            code = 1;
            message = "이메일 불일치";
        }

        Messenger messenger = new Messenger();
        messenger.getCode();
        messenger.getMessage();

        return messenger;

    }

}
