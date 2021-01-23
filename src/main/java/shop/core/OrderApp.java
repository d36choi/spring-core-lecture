package shop.core;

import shop.core.member.Grade;
import shop.core.member.Member;
import shop.core.member.MemberService;
import shop.core.member.MemberServiceImpl;
import shop.core.order.Order;
import shop.core.order.OrderService;
import shop.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
//        MemberService memberService = new MemberServiceImpl(null);
//        OrderService orderService = new OrderServiceImpl(null,null);

        Long memberId = 1L;
        Member member = new Member(memberId,"member", Grade.VIP);
        memberService.joinMember(member);

        Order order = orderService.createOrder(memberId,"itemA",20000);
        System.out.println("order = "+order);
        System.out.println(order.calculatePrice());
    }

}
