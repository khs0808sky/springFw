package app.labs.ex04.aop02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {


	// PointCut(핵심코드)
	@Pointcut(value = "execution(* app.labs.ex04..HelloService.sayHello(..))")
	private void helloPointcut() {
	}

	@Pointcut(value = "execution(* app.labs.ex04..HelloService.sayGoodbye(..))")
	private void goodbyePointcut() {
	}

	// Advice(공통코드 + 시점)
	@Before("helloPointcut()")
	public void beforeLog(JoinPoint joinPoint) { // Aspect(공통코드)
		System.out.println(">>> Log : " + new java.util.Date());
	}

	@AfterReturning(pointcut = "goodbyePointcut()", returning = "message")
	public void afterLog(JoinPoint joinPoint, Object message) { // Aspect
		System.out.println(">>> Log:" + new java.util.Date());
		System.out.println(">>> message:" + message.toString());
	}

	
	@Around("helloPointcut() || goodbyePointcut()")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {

		Signature s = joinPoint.getSignature();
		String methodName = s.getName();
		System.out.println("[Log] Before : " + methodName + " time check start");

		long startTime = System.nanoTime();

		Object result = null;

		try {
			result = joinPoint.proceed();
		} catch (Exception ex) {
			System.out.println("[Log] Exception : " + methodName);
		} finally {
			System.out.println("[Log] Finally : " + methodName);
		}

		long endTime = System.nanoTime();
		System.out.println("[Log] After : " + methodName + " time check end");
		System.out.println("[Log] " + methodName + " : " + (endTime - startTime) + "ns");

		return result;

	}
}
