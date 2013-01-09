package org.amm.pc.solutions;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

public class Puzzle_01_Test {

	@Test
	public void solution_1_test() {
		assertEquals(new BigInteger("274877906944"), Puzzle_01.solution_1());
	}
	
	@Test
	public void solution_2_test() {
		assertEquals(274877906944l, Puzzle_01.solution_2());
	}

}
