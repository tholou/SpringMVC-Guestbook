package com.guestbook;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.guestbook.GuestBookApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GuestBookApplication.class)
@WebAppConfiguration
public class GuestBookApplicationTests {

	@Test
	public void contextLoads() {
	}

}
