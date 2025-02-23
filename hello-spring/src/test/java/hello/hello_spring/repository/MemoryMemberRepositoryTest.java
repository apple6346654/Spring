package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static hello.hello_spring.repository.MemoryMemberRepository.store;
import static org.assertj.core.api.Assertions.*;
//TTD 테스트 주도개발 (테스트를 먼저 작성하고 나중에 개발)

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach //어떤 동작이 끝난 후 함수 실행 하는거
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("Spring");

        repository.save(member);

        Member result= repository.findById(member.getId()).get();

        //Assertions.assertEquals(member ,result); //member, result 값이 같은지 확인
        assertThat(member).isEqualTo(result);//member, result 값이 같은지 확인 (영한이 형은 이걸 좋아함)

    }
    @Test
    public void findById() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member1.setName("spring2");
        repository.save(member2);

    }

    @Test
    public void clearStore() {
        store.clear();
    }
}
