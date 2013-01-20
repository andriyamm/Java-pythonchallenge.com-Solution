package org.amm.pc.solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Puzzle_06 {

	public static final String PATTERN_PAIR_ARRAY = "(lp.+aa";
	public static final String PATTERN_PAIR = "(g.+a";
	public static final String PATTERN_QUANTITY = "(i\\d+";
	public static final String PATTERN_CHARACTER = "g\\d";
	public static final String URL_STRING = "http://www.pythonchallenge.com/pc/def/banner.p";

	
	private class Pair {
		char character;
		int quantity;
	}

	public void solution_0() {
		//TODO
	}

	private String getFileContents(){

		StringBuffer sb = new StringBuffer();
		
		URL url = new URL(URL_STRING);
		BufferedReader buffer = new BufferedReader(new InputStreamReader(
				url.openStream()));

		String inputLine = null;
		while ((inputLine = buffer.readLine()) != null) {
		
		}

		return sb;
	}
	
	private char getSymbol() {
		// TODO
		return 'q';
	}

	private int getQuantity() {
		// TODO
		return 0;
	}
}
