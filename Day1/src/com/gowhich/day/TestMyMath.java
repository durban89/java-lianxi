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

}
