package app.labs.ex03.di03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"app.labs.ex03.di03"})
public class AppConfig {
	
	@Bean
	IHelloService helloService() {
		return new HelloService();
	}

}
