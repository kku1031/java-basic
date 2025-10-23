package store.kanggyeonggu.api.member.service;

import store.kanggyeonggu.api.member.domain.MemberDTO;

public interface MemberService {

    //
    public void save(MemberDTO memberDTO);

    public void update(MemberDTO memberDTO);

    public void delete(MemberDTO memberDTO);

    // find 쿼리
    public void findById(MemberDTO memberDTO);

    public void findAll(MemberDTO memberDTO);

}
