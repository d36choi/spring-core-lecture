package shop.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
    basePackages = "shop.core.member", // 찾을 패키지 위치 지정.
    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
// 설정 정보를 컴포넌트스캔 대상에서 제외한다. (예제 컨픽파일들 살려놓기위해)
public class AutoAppConfig {
}
