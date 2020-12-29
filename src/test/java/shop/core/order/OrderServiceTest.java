package shop.core.order;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import shop.core.member.Grade;
import shop.core.member.Member;
import shop.core.member.MemberService;
import shop.core.member.MemberServiceImpl;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId,"member", Grade.VIP);
        memberService.joinMember(member);

        Order order = orderService.createOrder(memberId,"itemA",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
