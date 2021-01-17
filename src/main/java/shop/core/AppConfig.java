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
     */
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }
    
    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new FixDiscountPolicy());
    }
}
