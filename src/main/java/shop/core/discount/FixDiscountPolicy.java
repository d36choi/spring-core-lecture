package shop.core.discount;

import shop.core.member.Grade;
import shop.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            // enum은 equal 이 맞다
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
