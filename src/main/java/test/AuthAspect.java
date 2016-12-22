package test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by DONGCHULKIM on 2016-12-22.
 */
@Aspect
@Component
public class AuthAspect {
	/**
	 * Test AspectJ
	 *
	 * @throws Exception
	 */
	@Pointcut("@target(test.AuthorizeTo) || @annotation(test.AuthorizeTo)")
	public void process() {
		System.out.println("pointcut");
	}

	@Before("process()")
	public void beforeProcess(JoinPoint joinPoint) throws Throwable {
		System.out.println("beforeProcess");
		System.out.println(joinPoint.getTarget());
	}

	@Around("process()")
	public void AroundProcess(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("AroundProcess - start");
		proceedingJoinPoint.proceed();
		System.out.println("AroundProcess - end");
	}

	@AfterThrowing(pointcut = "process()", throwing = "exception")
	public void AfterThrowing(JoinPoint joinPoint, Exception exception) throws Exception {
		System.out.println("afterThrowing");
		System.out.println(exception);
		throw new Exception("Error!!!!!", exception);
	}
}
