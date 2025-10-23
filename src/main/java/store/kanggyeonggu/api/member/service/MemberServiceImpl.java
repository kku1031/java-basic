package store.kanggyeonggu.api.member.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import store.kanggyeonggu.api.member.domain.MemberDTO;
import store.kanggyeonggu.api.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public void save(MemberDTO memberDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void update(MemberDTO memberDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(MemberDTO memberDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void findById(MemberDTO memberDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void findAll(MemberDTO memberDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

}