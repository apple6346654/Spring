package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 맴버 저장시켜줌
    Optional<Member> findById(Long id); //id 찾게해줌
    Optional<Member> findByName(String name); //name 찾게해줌
    List<Member> findAll(); // 전체 찾기
}
