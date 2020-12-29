package shop.core.member;

public interface MemberService {

    void joinMember(Member member);
    Member findMember(Long memberId);

}
