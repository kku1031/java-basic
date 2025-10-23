package store.kanggyeonggu.api.auth.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import store.kanggyeonggu.api.auth.domain.LoginDTO;
import store.kanggyeonggu.api.auth.domain.LoginVO;
import store.kanggyeonggu.api.common.domain.Messenger;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    // 들여쓰기 해야 자식이 됨
    @Override
    public Messenger login(LoginDTO loginDTO) {

        LoginVO loginVO = new LoginVO();

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
        messenger.setCode(code);
        messenger.setMessage(message);

        return messenger;
    }
}
