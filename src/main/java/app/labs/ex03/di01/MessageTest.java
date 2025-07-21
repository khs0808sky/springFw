package app.labs.ex03.di01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageTest {

	public static void main(String[] args) {
		Message msg;
		msg = new MessageEn();
		//msg = new MessageKo();
		
		msg.getMessage();
		
		// 지정된 xml을 이용하여 객체를 bean container생성한 뒤 bean 정보를 context 객체를 이용해 사용.
		AbstractApplicationContext context = new GenericXmlApplicationContext("classpath:app/labs/ex03/di01/application-config.xml");
		
		// id가 messageService인 빈을 가져와라.
		// 의존성 주입(Dependency Injection) - 의존성에 관련된 정보를 분리하여 사용한다.
		Message msgService = context.getBean("messageService", Message.class);
		msgService.getMessage();
	}

}
