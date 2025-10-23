package store.kanggyeonggu.api.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import store.kanggyeonggu.api.member.domain.MemberDTO;
import store.kanggyeonggu.api.member.service.MemberService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("") // get쓰면 파일 업로드가 안됨 - 등록은 하나 밖에 없으니까 디폴트 만 던짐(주소값 안넣고)
    public void save(@RequestBody MemberDTO memberDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @PutMapping("/{id}")
    public void update(@RequestBody MemberDTO memberDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @GetMapping("/id/{id}")
    public void findById(@PathVariable String id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @GetMapping("/all")
    public void findAll(MemberDTO memberDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

}
