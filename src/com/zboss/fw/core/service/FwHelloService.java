package com.zboss.fw.core.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FwHelloService {

	// @Resource
	// private FwHelloOneService fwHelloOneService;

	// @Resource
	// private FwHelloTwoService fwHelloTwoService;

	@Transactional(readOnly = false)
	public void test1() {
		// FwHelloOne helloOne = new FwHelloOne();
		// helloOne.setId(CommonUtil.randomUUID());
		// helloOne.setStringOne("Hello,StringOne!");
		// helloOne.setIntegerOne(1);
		// helloOne.setLongOne(1L);
		// helloOne.setFloatOne((float) 1);
		// helloOne.setDoubleOne(1D);
		// helloOne.setMoneyOne(BigDecimal.valueOf(1));
		// helloOne.setDateOne(new Date());
		// helloOne.setBoolOne(true);
		// helloOne.setEnumOne(HelloOneEnum.你好);
		//
		// fwHelloOneService.save(helloOne);
	}

	@Transactional(readOnly = false)
	public void test2() {
		// FwHelloTwo helloTwo = new FwHelloTwo();
		// helloTwo.setId(CommonUtil.randomUUID());
		// helloTwo.setStringTwo("Hello,StringTwo!");
		// helloTwo.setIntegerTwo(2);
		// helloTwo.setLongTwo(2L);
		// helloTwo.setFloatTwo((float) 2);
		// helloTwo.setDoubleTwo(2D);
		// helloTwo.setMoneyTwo(BigDecimal.valueOf(2));
		// helloTwo.setDateTwo(new Date());
		// helloTwo.setBoolTwo(false);
		// helloTwo.setEnumTwo(HelloTwoEnum.HELLO);
		//
		// fwHelloTwoService.save(helloTwo);
	}

	// @Transactional(readOnly = false)
	// public void test2() throws RuntimeException {
	// FwHelloOne testdata1 = new FwHelloOne();
	// testdata1.setFoo(2);
	// dao.save(testdata1);
	//
	// FwHelloOne testdata2 = new FwHelloOne();
	// testdata2.setFoo(3);
	// dao.save(testdata2);
	//
	// dao.flush();
	//
	// FwHelloOne data = FwHelloOne(2);
	// data.getId();
	//
	// throw new RuntimeException();
	// }

	// @Transactional(readOnly = true)
	// public FwHelloOne findByFoo(Integer foo) {
	// return ((IFwHelloOneDao) dao).getByFoo(foo);
	// }

}
