package store.kanggyeonggu.api.auth.service;

import org.springframework.stereotype.Service;

import store.kanggyeonggu.api.auth.domain.LoginDTO;
import store.kanggyeonggu.api.auth.domain.LoginVO;

@Service
public class LoginService {
    //들여쓰기 해야 자식이 됨
    public boolean login(LoginDTO loginDTO) {
        System.out.println("로그인 서비스로 들어옴");        
        System.out.println("DTO로 전달된 이메일 : " + loginDTO.getName());
        System.out.println("DTO로 전달된 비밀번호 : " + loginDTO.getPassword());

        LoginVO loginVO = new LoginVO();

        System.out.println("vo에서 서비스로 전달된 이메일 : " + loginVO.getName());
        System.out.println("vo에서 서비스로 전달된 비밀번호 : " + loginVO.getPassword());

        


        return true;
    }
}
