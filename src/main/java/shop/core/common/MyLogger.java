package shop.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
// http 요청 당 생성되고 요청 끝나는 시점에 소멸되는 스코프를 가지게 되었다
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestURL + "]" + message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("uuid = " + uuid + " request scope bean created.");
        // 빈 생성시점에 자동으로
        // 겹칠확률이 로또 맞을 확률만큼 낮은 유니크한 아이디를 생성한다
    }

    @PreDestroy
    public void close() {

    }
}
