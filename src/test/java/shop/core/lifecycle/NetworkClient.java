package shop.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements DisposableBean, InitializingBean {

    private String url;

    public NetworkClient() {
        System.out.println("constructor 호출 url = "+url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connected: " + url);
    }

    public void call(String msg) {
        System.out.println("call = "+ url);
        System.out.println("msg = " + msg);
    }

    public void disconnect() {
        System.out.println("close " + url);
    }

    @Override
    public void destroy() throws Exception {
        disconnect();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        connect();
        call("초기화 연결 메시지");
    }
}
