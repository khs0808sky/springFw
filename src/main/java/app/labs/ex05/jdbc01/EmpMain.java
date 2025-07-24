package app.labs.ex05.jdbc01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class EmpMain {

	public static void main(String[] args) {

		AbstractApplicationContext context = new GenericXmlApplicationContext("classpath:config/jdbc01/application-config.xml");
		
		IEmpService empService = context.getBean("empService", IEmpService.class);
		
		System.out.println("-- 사원수 조회");
		System.out.println(empService.getEmpCount());
		
		context.close();
	}

}
