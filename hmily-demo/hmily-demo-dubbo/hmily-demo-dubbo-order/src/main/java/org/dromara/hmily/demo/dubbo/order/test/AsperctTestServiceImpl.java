package org.dromara.hmily.demo.dubbo.order.test;

import org.springframework.stereotype.Service;

@Service
public class AsperctTestServiceImpl implements AspectTestService {

	@Override
	public void out() {
		System.out.println("aaaaaaaaa");
		
	}

}
