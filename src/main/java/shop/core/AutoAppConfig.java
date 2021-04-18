package shop.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
    basePackages = "shop.core.member", // ã�� ��Ű�� ��ġ ����.
    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
// ���� ������ ������Ʈ��ĵ ��󿡼� �����Ѵ�. (���� �������ϵ� �����������)
public class AutoAppConfig {
}
