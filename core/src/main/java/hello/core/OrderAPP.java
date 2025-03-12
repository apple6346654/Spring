package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImp;

public class OrderAPP {
    public static void main(String[] args) {

        AppConfig appconfig = new AppConfig();
        MemberService memberService = appconfig.memberService();
        OrderService orderService = appconfig.orderService();


        //        MemberService memberService = new MemberServiceImpl(null);
        //        OrderService oriderService = new OrderServiceImp(null ,null);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);
    }
}
