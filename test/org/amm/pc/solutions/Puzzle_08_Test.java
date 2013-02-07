package org.amm.pc.solutions;

import java.io.IOException;

import org.junit.Test;

public class Puzzle_08_Test {

	private static final String FILENAME = "oxygen.png";
	@Test
	public void solution_01_Test() {
		Puzzle_08 p08 = new Puzzle_08();
		try {
			System.out.println(p08.solution_0(FILENAME));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
