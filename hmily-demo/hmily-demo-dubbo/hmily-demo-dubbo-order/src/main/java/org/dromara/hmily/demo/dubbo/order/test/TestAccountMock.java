package org.dromara.hmily.demo.dubbo.order.test;

import org.dromara.hmily.demo.dubbo.account.api.dto.AccountDTO;
import org.dromara.hmily.demo.dubbo.account.api.dto.AccountNestedDTO;
import org.dromara.hmily.demo.dubbo.account.api.entity.AccountDO;
import org.dromara.hmily.demo.dubbo.account.api.service.AccountService;

public class TestAccountMock implements AccountService {

	@Override
	public void payment(AccountDTO accountDTO) {
		System.out.println("error1");
		throw new RuntimeException("error1");
		
	}

	@Override
	public boolean testPayment(AccountDTO accountDTO) {
		System.out.println("error2");
		throw new RuntimeException("error2");
	}

	@Override
	public boolean paymentWithNested(AccountNestedDTO accountNestedDTO) {
		System.out.println("error3");
		throw new RuntimeException("error3");
	}

	@Override
	public AccountDO findByUserId(String userId) {
		System.out.println("error4");
		throw new RuntimeException("error4");
	}

}
