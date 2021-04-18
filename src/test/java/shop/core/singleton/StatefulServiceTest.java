package shop.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;

class StatefulServiceTest {

    // ������: ������ ���� �⺻������ �̱����̱� ������, ���¸� �������� �ȵȴ�.
    // �̱��濡 stateless ���� �ʰԵȴٸ� �Ʒ��� ���� ���� ���� ����.

    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // thread A : a user 1���� �ֹ�
        statefulService1.order("userA",10000);
        // thread B : B user 2���� �ֹ�
        statefulService2.order("userB",20000);

        // threadA: �ݾ� ��ȸ
        int price = statefulService1.getPrice();
        System.out.println("price = " + price);

        assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}