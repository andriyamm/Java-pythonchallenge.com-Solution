package org.amm.pc;

public interface JCConstants {
	
	interface Puzzle_03{
		public static final String PATTERN = "[a-zA-Z]";
	}
	
	interface Puzzle_04{
		public static final String PATTERN = "[^A-Z]+[A-Z]{3}([a-z])[A-Z]{3}[^A-Z]+";
	}
	
	interface Puzzle_05{
		public static final String PATTERN = "and the next nothing is (\\d+)";
	}
	
	interface Puzzle_08{
		public static final String PATTERN = "\\d+";
	}
}
