package xml;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import shop.core.member.MemberService;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlAppContext {

    // XML ������ ���� ���� ������ �����Ѵ�.
    @Test
    void xmlAppContext() {
        GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = ac.getBean("memberService",MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);

    }
}
