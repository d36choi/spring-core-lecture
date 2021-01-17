package shop.core;

import shop.core.discount.DiscountPolicy;
import shop.core.discount.FixDiscountPolicy;
import shop.core.member.MemberRepository;
import shop.core.member.MemberService;
import shop.core.member.MemberServiceImpl;
import shop.core.member.MemoryMemberRepository;
import shop.core.order.OrderService;
import shop.core.order.OrderServiceImpl;

public class AppConfig {

    /**
     * @return 
     * 여기서 멤버서비스의 구현체를 무엇으로 할지를 결정시키도록 한다. --> 생성자 주입의 원리
     * 외부에서 구현객체의 주입을 결정.
     * refactor: 역할과 구현을 구분한다. new MemoryMemberRepository() 부분이 중복 제거 되었다
     */
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
