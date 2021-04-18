package shop.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;

class StatefulServiceTest {

    // 총정리: 스프링 빈은 기본적으로 싱글톤이기 때문에, 상태를 가져서는 안된다.
    // 싱글톤에 stateless 하지 않게된다면 아래와 같이 결제 문제 터짐.

    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // thread A : a user 1만원 주문
        statefulService1.order("userA",10000);
        // thread B : B user 2만원 주문
        statefulService2.order("userB",20000);

        // threadA: 금액 조회
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