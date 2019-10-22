import org.dromara.hmily.demo.dubbo.order.DubboHmilyOrderApplication;
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
	
	@Test
	public void test1() {
		System.out.println(""+testService.getClass().toString());
		testService.out();
	}
}
