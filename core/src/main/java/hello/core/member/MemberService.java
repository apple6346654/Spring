package hello.core.member;

public interface MemberService {

    void join(Member member); //로그인

    Member findMember(Long memberId); //회원조회


}
