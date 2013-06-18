package com.zboss.fw.core.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public abstract class BaseTest extends AbstractTransactionalJUnit4SpringContextTests {

}
