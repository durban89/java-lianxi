package com.gowhich.day;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMyMath {

	@Test
	public void testAdd() {
		MyMath math = new MyMath();
		int add = math.add(3, 4);
		assertEquals(7, add);
		
	}
	
	@Test
	public void testMinus() {
		MyMath math = new MyMath();
		int minus = math.minus(6, 9);
		assertEquals(-3, minus);
	}

}
