package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImp implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();


    @Override
    public Order createOrder(Long membmerId, String itemName, int itemPrice) { //SRP 단일책임원칙
                                                                               //클래스는 단 하나의 책임만 가져야 한다
       Member member = memberRepository.findById(membmerId);
       int dicountPrice = discountPolicy.discount(member, itemPrice);

       return new Order(membmerId, itemName, itemPrice, dicountPrice);
    }
}
