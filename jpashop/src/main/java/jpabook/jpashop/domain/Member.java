package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id") // 컬럼 이름 지정
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") //order테이블에 있는 member 필드에 의해 매핑 된거야.
                                    // 여기서 값을 넣어도 FK값은 변경 되지 않는다.
    private List<Order> orders = new ArrayList<>();
}
