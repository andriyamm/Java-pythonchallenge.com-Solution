package org.amm.pc.solutions;

import java.math.BigInteger;

/**
 * puzzle's url -http://www.pythonchallenge.com/pc/def/0.html
 */
public class Puzzle_01 {

	public static BigInteger solution_1(){
		return new BigInteger("2").pow(38);
	}
	
	public static long solution_2(){
		return (long) Math.pow(2, 38);
	}
}
