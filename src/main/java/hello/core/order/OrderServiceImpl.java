package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor //생성자를 자동 생성 해줌
public class OrderServiceImpl implements OrderService {

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    /*private  MemberRepository memberRepository;
    private  DiscountPolicy discountPolicy;*/

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    /*//필드 주입
    @Autowired private  MemberRepository memberRepository;
    @Autowired private  DiscountPolicy discountPolicy;*/


    /*@Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }*/

    //@Autowired 생성자가 하나 있으면 @Autowired를 생략해도 됨
    /*public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }*/

    @Override
    public Order createOrder(Long memeberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memeberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memeberId, itemName, itemPrice, discountPrice);
    }
    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
