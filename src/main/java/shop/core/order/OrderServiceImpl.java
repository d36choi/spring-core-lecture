package shop.core.order;

import shop.core.discount.DiscountPolicy;
import shop.core.discount.FixDiscountPolicy;
import shop.core.discount.RateDiscountPolicy;
import shop.core.member.Member;
import shop.core.member.MemberRepository;
import shop.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
// DIP 위반이다. 인터페이스가 아니라 구현체에 의존하는 형태다.
    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // 이렇게 하면 DIP는 지키지만 NPE가 뜬다

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        // 설계가 잘된 것임. 오더서비스입장에선 할인 정책에 관련해서는 신경쓰지 않음. 단일 체계 원칙을 잘 지킴

        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
