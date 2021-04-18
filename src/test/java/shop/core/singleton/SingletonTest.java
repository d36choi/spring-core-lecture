package shop.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shop.core.AppConfig;
import shop.core.member.MemberService;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    @DisplayName("���������� ���� DI container")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        //1. ��ȸ: ȣ�� ���� ��ü ����
        MemberService memberService1 = appConfig.memberService();
        //2. ��ȸ: ȣ�� ���� ��ü ����
        MemberService memberService2 = appConfig.memberService();
        // ���� �� �ٸ� ���� Ȯ��
        System.out.println("mem1 = " + memberService1);
        System.out.println("mem2 + " + memberService2);

        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("singleton pattern ���� ���")
    void singletonTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singleton1 = "+singletonService1);
        System.out.println("singleton2 = "+singletonService2);
        assertThat(singletonService1).isSameAs(singletonService2);
        // same == (��ü)
        // equal equals (�޼����)
    }

    @Test
    @DisplayName("spring container and singleton")
    void springContainer() {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        //1. ��ȸ: ȣ�� ���� ��ü ����
        MemberService memberService1 = applicationContext.getBean("memberService",MemberService.class);
        //2. ��ȸ: ȣ�� ���� ��ü ����
        MemberService memberService2 = applicationContext.getBean("memberService",MemberService.class);
        // ���� �� �ٸ� ���� Ȯ��
        System.out.println("mem1 = " + memberService1);
        System.out.println("mem2 + " + memberService2);

        assertThat(memberService1).isSameAs(memberService2);
    }

}
