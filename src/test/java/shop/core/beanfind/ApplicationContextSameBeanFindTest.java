package shop.core.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shop.core.AppConfig;
import shop.core.discount.DiscountPolicy;
import shop.core.member.MemberRepository;
import shop.core.member.MemoryMemberRepository;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("둘이상의 같은 타입이 있다면 중복오류")
    void findBeanByTypeDuplicate() {
//        MemberRepository bean = ac.getBean(MemberRepository.class);
        assertThrows(NoUniqueBeanDefinitionException.class, () ->
            ac.getBean(MemberRepository.class)
        );
    }
    @Test
    @DisplayName("둘이상의 같은 타입이 있다면 빈 이름을 지정하면 된다")
    void findBeanByTypeDuplicateSuccess() {
        MemberRepository bean = ac.getBean("memberRepository1",MemberRepository.class);
        assertThat(bean).isInstanceOf(MemberRepository.class);
    }
    @Test
    @DisplayName("특정타입 모두 조회")
    void findAllBeanByType() {
        Map<String,MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));

        }
        System.out.println("beansOfType = " + beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Configuration
    static class SameBeanConfig {
        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }
        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }
}
