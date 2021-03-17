package xml;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import shop.core.member.MemberService;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlAppContext {

    // XML 파일을 통해 빈을 가져와 동작한다.
    @Test
    void xmlAppContext() {
        GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = ac.getBean("memberService",MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);

    }
}
