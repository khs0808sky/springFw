package app.labs.ex03.di01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		System.out.println("Hello~ 홍길동");
		
		// 1) 멤버필드
		// HelloController controller = new HelloController();
		
		// 2) 생성자 - 서비스 생성을 컨트롤러에서 분리하여 유연성 확보
		// IHelloService helloService = new HelloService();
		// HelloController controller = new HelloController(helloService);
		
		// 3) Setter - 서비스 생성을 컨트롤러에서 분리하여 유연성 확보
		// IHelloService helloService = new HelloService();
		// HelloController controller = new HelloController();
		// controller.setHelloService(helloService);
		
		// 4) Spring DI
		AbstractApplicationContext context = new GenericXmlApplicationContext("classpath:config/di01/application-config.xml");
		
		// 5) 생성자 이용
		HelloController controller = context.getBean("helloController", HelloController.class);
		controller.hello("홍길동");
		
		// 6) Setter 이용
		HelloController controller2 = context.getBean("helloController2", HelloController.class);
		controller2.hello("홍길동");
		
		HelloController controller3 = context.getBean("helloController3", HelloController.class);
		controller3.hello("홍길동");
	}

}
