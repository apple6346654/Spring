package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) { //테스트 코드 바로 만들기 단축키 ctrl + shift + t
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent/100;
        }else{
            return 0;
        }
    }
}
