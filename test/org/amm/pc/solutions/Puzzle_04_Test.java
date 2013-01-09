package org.amm.pc.solutions;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class Puzzle_04_Test {

	public static final String FILENAME = "equality.txt";
	
	@Test
	public void solution_0_test() throws IOException {
		assertEquals("linkedlist", Puzzle_04.solution_0(FILENAME));
	}
	
	@Test
	public void solution_1_test() throws IOException {
		assertEquals("linkedlist", Puzzle_04.solution_1(FILENAME));
	}
}
