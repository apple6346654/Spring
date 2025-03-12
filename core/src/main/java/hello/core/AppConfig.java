package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImp;

public class AppConfig {

    public MemberService memberService(){ //생성자 주입
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImp(new MemoryMemberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
       // return new FixDiscountPolicy();  //바꾸고 싶을 떄 이부분만 바꾸면 된다!!
        return new RateDiscountPolicy();
    }
}
