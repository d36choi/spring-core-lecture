package shop.core.autowired;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;
import shop.core.member.Member;

import java.util.Optional;

@SpringBootTest
public class AutowiredTest {

    @Test
    void autowiredTest() {
        final ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        // Member 란 bean 이 없다. 이 경우
        // 1. required = true 면 에러 발생. UnsatisfiedDependencyException, false면 실행안함
        // 2. 실행되지만 Member Bean 은 null
        // 3. noBean3 = Optional.empty
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }
        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }
        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
