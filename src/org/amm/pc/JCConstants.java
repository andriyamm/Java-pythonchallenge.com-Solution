package org.amm.pc;

public interface JCConstants {
	
	interface Puzzle_03{
		public static final String PATTERN = "[a-zA-Z]";
	}
	
	interface Puzzle_04{
		public static final String PATTERN = "[^A-Z]+[A-Z]{3}([a-z])[A-Z]{3}[^A-Z]+";
	}
}
