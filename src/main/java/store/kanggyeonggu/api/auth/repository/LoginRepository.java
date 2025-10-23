package store.kanggyeonggu.api.auth.repository;

import org.springframework.stereotype.Repository;

import store.kanggyeonggu.api.auth.domain.LoginDTO;
import store.kanggyeonggu.api.auth.domain.LoginEntity;
import store.kanggyeonggu.api.common.domain.Messenger;

@Repository
public class LoginRepository {

    public Messenger loginRepository(LoginEntity loginEntity) {
        return null;
    }

    public void save(LoginDTO loginDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
}
