import java.math.BigDecimal;

import org.dromara.hmily.demo.dubbo.order.DubboHmilyOrderApplication;
import org.dromara.hmily.demo.dubbo.order.service.OrderService;
import org.dromara.hmily.demo.dubbo.order.service.PaymentService;
import org.dromara.hmily.demo.dubbo.order.test.AspectTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=DubboHmilyOrderApplication.class)
//@ImportResource({"classpath:spring-dubbo.xml"})
//@MapperScan("org.dromara.hmily.demo.dubbo.order.mapper")
public class MyTest {
	@Autowired
	private AspectTestService testService;
	
	@Autowired
	private OrderService orderService;
	
	@Test
	public void test1() {
		System.out.println(""+testService.getClass().toString());
		testService.out();
	}
	
	@Test
	public void test2() {
		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				orderService.orderPay(1, new BigDecimal(10));
				
			}
		}); 
		t1.start();
		Thread t2 = new Thread(new Runnable() {
			
			public void run() {
				orderService.orderPay(1, new BigDecimal(10));
				
			}
		}); 
		t2.start();
		try {
 			Thread.currentThread().sleep(100*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
