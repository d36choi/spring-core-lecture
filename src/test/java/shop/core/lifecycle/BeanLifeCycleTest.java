package shop.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        final ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(LifecycleBean.class);
        final NetworkClient bean = applicationContext.getBean(NetworkClient.class);
        applicationContext.close();
    }
    @Configuration
    static class LifecycleBean {
        @Bean(initMethod = "init", destroyMethod = "shutdown")
        // code ����ġ�� �ܺζ��̺귯���� �����ֱ� ���� �����ϴ�
        public NetworkClient networkClient () {
            final NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("https://hellospring.com");
            return networkClient;
        }

    }
}
