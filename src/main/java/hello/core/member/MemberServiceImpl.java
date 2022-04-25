package hello.core.member;

public class MemberServiceImpl implements MemberService{
    // 현재 추상화에도 의존한고 구체화에도 문제가됨 (나중에 변경할때 커다란 문제가 될 수 있음 DIP를 위반!)
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
