package shop.core.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import shop.core.discount.DiscountPolicy;
import shop.core.discount.FixDiscountPolicy;
import shop.core.discount.RateDiscountPolicy;
import shop.core.member.Member;
import shop.core.member.MemberRepository;
import shop.core.member.MemoryMemberRepository;

// cmd + f12 를 누르면 생성자가 롬복에 의해 추가된 것을 확인 가능하다
// RequiredArgsConstructor 어노테이션은 final keyword 붙은 필드값을 생성자로 주입시킨다.
@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
// DIP 위반이다. 인터페이스가 아니라 구현체에 의존하는 형태다.
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        // 설계가 잘된 것임. 오더서비스입장에선 할인 정책에 관련해서는 신경쓰지 않음. 단일 체계 원칙을 잘 지킴

        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
