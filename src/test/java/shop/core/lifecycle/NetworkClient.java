package shop.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("constructor 호출 url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connected: " + url);
    }

    public void call(String msg) {
        System.out.println("call = " + url);
        System.out.println("msg = " + msg);
    }

    public void disconnect() {
        System.out.println("close " + url);
    }

    public void shutdown() throws Exception {
        disconnect();
    }

    public void init() {
        connect();
        call("초기화 연결 메시지");
    }
}
