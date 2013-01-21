package org.amm.pc.solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.amm.pc.utils.JCHelper;

public class Puzzle_06 {

	public static final String PATTERN_PAIR_ARRAY = "(lp(.+)aa";
	public static final String PATTERN_PAIR = "(g(.+)a";
	public static final String PATTERN_QUANTITY = "(I(\\d+)";
	public static final String PATTERN_CHARACTER = "g(\\d)";
	//public static final String URL_STRING = "http://www.pythonchallenge.com/pc/def/banner.p";
	public static final String FILENAME = "peak.txt";

	
	private class Pair {
		char character;
		int quantity;
	}

	public void solution_0() {
		try {
			StringBuffer sb = JCHelper.getFileContent(FILENAME);
			
			Pattern pattern = Pattern.compile(PATTERN_PAIR_ARRAY, Pattern.CASE_INSENSITIVE | Pattern.DOTALL | Pattern.MULTILINE);
			Matcher matcher = pattern.matcher(sb);
			if (matcher.find()) {
				matcher.group(1);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	private char getSymbol() {
		// TODO
		return '0';
	}

	private int getQuantity() {
		// TODO
		return 0;
	}
}
