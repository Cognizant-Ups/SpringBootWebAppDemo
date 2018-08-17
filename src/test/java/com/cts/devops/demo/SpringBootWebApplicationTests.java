package com.cts.devops.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * The type Spring boot web application tests.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootWebApplication.class)
@WebAppConfiguration
public class SpringBootWebApplicationTests {

	/**
	 * Context loads.
	 */
	@Test
	public void contextLoads() {
	}
}
