package shop.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shop.core.AppConfig;

public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
//        test  실행전 반드시 실행되게 함
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();



    }
    @Test
    void join() {
        //given
        Member member = new Member(1L,"memberA",Grade.VIP);


        //when
        memberService.joinMember(member);
        Member findMember = memberService.findMember(1L);
        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
