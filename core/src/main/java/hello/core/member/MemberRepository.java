package hello.core.member;

import org.springframework.stereotype.Component;

@Component
public interface MemberRepository {

    void save(Member member); //회원 저장

    Member findById(Long memberId); //아이디 찾기
}
