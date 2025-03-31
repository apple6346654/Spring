package jpabook.jpashop;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class) //스프링과 관련된 Test를 할 거다 //junit4에서 쓰는 문법
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;


    @Transactional// test 코드에서는 한번 실행후 바로 롤백한다.
                  // 한번 실행 했다고 데이터가 들어가면 다음 테스트를 못하기 떄문
    @Test
    public void testMember () throws Exception {
        //given
        Member member = new Member();
        member.setUsername("memberA");

        //when
        Long savedId = memberRepository.save(member);
        Member findMember = memberRepository.find(savedId);

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());

    }


}