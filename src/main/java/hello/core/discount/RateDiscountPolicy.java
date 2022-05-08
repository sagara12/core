package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy{

    // 할인율
    private int discountPercent = 10;

    //컨트롤 쉬프트 T (새로운 테스트 만들기)
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){
            return price * discountPercent/100;
        } else {
            return 0;
        }
    }
}
