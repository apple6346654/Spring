package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="orders") //테이블 이름 지정
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "orders_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") //fk가 member_id  // 연관관계 주인
    private Member member;
                                  //cascade를 쓰면 order를 저장할때 한번에 orderItems 부분까지 저장가능
    @OneToMany(mappedBy = "order" ,cascade = CascadeType.ALL) //order에 의해서 매핑이 됬다 즉 order쪽이 주인이다.
    private List<OrderItem> orderItems = new ArrayList<>();

                                  //cascade를 쓰면 order를 저장할때 delivery 부분까지 저장가능
    @OneToOne(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate;//주문시간, LocalDateTime 자바8문법~

    @Enumerated(EnumType.STRING)
    private OrderStatus status; //주문상태 [ORDER, CANCEL]


    //연관관계 메서드
    public void  setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);      //양방향 연관관계로 집어 넣는다. //여기 있는 this는 order객체

    }

    public void addOrderItems(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void SetDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }

}
