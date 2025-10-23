package store.kanggyeonggu.api.auth.service;

import store.kanggyeonggu.api.auth.domain.LoginDTO;
import store.kanggyeonggu.api.common.domain.Messenger;

public interface LoginService {
    // 추상 메소드
    public Messenger login(LoginDTO loginDTO);

}