package java基础视频;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class StackTest {
	private Stack<Integer> stack;
	private int initTestSize;

	@BeforeEach
	void setUp() throws Exception {
		stack = new Stack<>();
		initTestSize = 5;
		for(int i=0;i<initTestSize;i++) {
			stack.push(i);
		}
	}

	@AfterEach
	void tearDown() throws Exception {
	}


	@Test
	void testSize() {
		Assert.assertEquals(initTestSize, stack.size());
	}

	@Test
	void testPush() {
		stack.push(5);
	}

	@Test
	void testPop() throws Exception{
		for(int i=0;i<initTestSize;i++) {
			Assert.assertEquals(stack.pop().intValue(), initTestSize-1-i);
		}
//		stack.pop();
	}

	@Test
	void testPeek() {
		Assert.assertEquals(initTestSize-1, stack.peek().intValue());
		for(int i=0;i<initTestSize;i++) {
			stack.pop();
		}
		Assert.assertTrue(stack.isEmpty());
	}

	@Test
	void testIsEmpty() {
		Assert.assertFalse(stack.isEmpty());
		for(int i=0;i<initTestSize;i++) {
			stack.pop();
		}
		Assert.assertTrue(stack.isEmpty());
	}

	@Test
	void testSearch() {
		for(int i=0;i<initTestSize;i++) {
			Assert.assertEquals(i, stack.search(i));
		}
	}
	
	@Test
	public void testPushAndPop() {
		stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		Assert.assertEquals(3, stack.pop().intValue());
		stack.push(4);
		Assert.assertEquals(4, stack.peek().intValue());
		Assert.assertEquals(4, stack.pop().intValue());
	}

}
