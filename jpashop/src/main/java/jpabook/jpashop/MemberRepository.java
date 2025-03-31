package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

//Repository는 Entity를 찾아주는 얘? DAO랑 비슷한 개념

@Repository
public class MemberRepository {

    @PersistenceContext // JPA에서 사용하는 애노테이션으로, EntityManager를 스프링이 자동으로 주입해주는 역할
    private EntityManager em; //JPA에서 DB 작업(CRUD 등)을 실제로 처리하는 핵심 객체

    public Long save(Member member) {
        em.persist(member); //엔티티 객체를 영속성 컨텍스트에 등록하고, DB에 저장
        return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id); //Member 테이블에서 id인 데이터를 찾아서 Member 객체로 줘 라는 뜻
    }

}
