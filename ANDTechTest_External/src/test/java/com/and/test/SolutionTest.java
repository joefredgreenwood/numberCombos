package com.and.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test326() {
		String test = Solution.solution("326");
		assertEquals("632,623,362,326,263,236", test);
	}
	
	@Test
	public void testA_3B2_C6D() {
		String test = Solution.solution("A 3B2 C6D");
		assertEquals("632,623,362,326,263,236", test);
	}
	
	@Test
	public void testABC() {
		boolean thrown = false;
		try {
			Solution.solution("ABC");
		} catch (NumberFormatException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	

}
