package org.amm.pc.solutions;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class Puzzle_05_Test {

	public static final String URL = "http://www.pythonchallenge.com/pc/def/linkedlist.php?nothing=";
	
	@Test
	public void solution_0_test() throws IOException {
		assertEquals("peak", Puzzle_05.solution_0(URL));
	}

}
