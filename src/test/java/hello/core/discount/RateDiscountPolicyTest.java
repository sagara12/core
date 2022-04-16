package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10할인이 적용 되어야 한다")
    void vip_o(){
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then(알트 + 앤터 스태틱 선언하면 간결하게 만들수 있음)
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP는 10할인이 적용 되지 않아야 한다")
    void vip_x(){
        //given
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then (알트 + 앤터 스태틱 선언하면 간결하게 만들수 있음)
        assertThat(discount).isEqualTo(0);
    }
}