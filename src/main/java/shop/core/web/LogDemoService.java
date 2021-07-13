package shop.core.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import shop.core.common.MyLogger;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final ObjectProvider<MyLogger> myLoggerProvider;
    public void logic(String testId) {
        final MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("ID : " + testId);
    }
}
