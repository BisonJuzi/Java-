package java基础视频;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class HelloWordTest {
	ArrayList l = null;
	@BeforeEach
	void setUp() throws Exception {
		l = new ArrayList();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testSayHello() {
		l.add("s");
	}
	
	@Test
	void testSayHello2() {
		l.add("a");
		Assert.assertEquals(1, l.size());
	}

}
