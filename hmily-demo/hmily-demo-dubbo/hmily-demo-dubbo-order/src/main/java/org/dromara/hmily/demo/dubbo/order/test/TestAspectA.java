package org.dromara.hmily.demo.dubbo.order.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class TestAspectA implements Ordered {
	
	@Pointcut("execution(public * org.dromara.hmily.demo.dubbo.order.test.AspectTestService.*(..))")
	public void pointCut() {}
	
	@Around("pointCut()")
	public Object interceptTccMethod(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("TestAspectA start");
        Signature ss =proceedingJoinPoint.getSignature();
        
        Object sg =proceedingJoinPoint.getTarget();
        MethodSignature ms =(MethodSignature)ss;
        System.out.println(sg instanceof AsperctTestServiceImpl);
        Object o= proceedingJoinPoint.proceed();
        System.out.println("TestAspectA en");
        return o;
    }
	
	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return Ordered.HIGHEST_PRECEDENCE;
	}

}
