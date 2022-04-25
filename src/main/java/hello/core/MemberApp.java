package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        //MemberService memberService = new MemberServiceImpl();
        //컨트롤 알트 V 자동 생성
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        //soutv 치면 나옴
        System.out.println("findMember = " + findMember.getName());
        System.out.println(" new member = " + member.getName());


    }
}
