package org.amm.pc.solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.amm.pc.utils.JCHelper;

public class Puzzle_06 {

	public static final String PATTERN_PAIR_ARRAY = "(lp(.+)aa";
	public static final String PATTERN_PAIR = "(g(.+)a";
	public static final String PATTERN_QUANTITY = "(I(\\d+)";
	public static final String PATTERN_CHARACTER = "g(\\d)";
	// public static final String URL_STRING =
	// "http://www.pythonchallenge.com/pc/def/banner.p";
	public static final String FILENAME = "peak.txt";

	private class Pair {
		char character;
		int quantity;

		public Pair(String symbol, int quantity2) {
			// TODO Auto-generated constructor stub
		}

		public char getCharacter() {
			return character;
		}

		public void setCharacter(char character) {
			this.character = character;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
	}

	public void solution_0() {
		try {
			String sb = JCHelper.getFileContent(FILENAME).toString();

			List<ArrayList<Pair>> banner = createBanner(sb);
			printBanner(banner);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void printBanner(List<ArrayList<Pair>> banner){
		//TODO
	}
	
	private List<ArrayList<Pair>> createBanner(String textBanner) {

		List<ArrayList<Pair>> banner = new ArrayList<ArrayList<Pair>>();

		Pattern pattern = Pattern.compile(PATTERN_PAIR_ARRAY, Pattern.DOTALL
				| Pattern.MULTILINE);
		Matcher matcher = pattern.matcher(textBanner);
		while (matcher.find()) {
			banner.add(getListOfPair(matcher.group(1)));
		}

		return banner;
	}

	private ArrayList<Pair> getListOfPair(String str) {

		Pattern pattern = Pattern.compile(PATTERN_PAIR, Pattern.DOTALL
				| Pattern.MULTILINE);
		Matcher matcher = pattern.matcher(str);
		List<Pair> list = new ArrayList<Pair>();

		while (matcher.find()) {
			String s = matcher.group();
			list.add(new Pair(getSymbol(s, PATTERN_CHARACTER),
					parseQuantity(getSymbol(s, PATTERN_QUANTITY))));
		}

		return null;
	}

	private String getSymbol(String sb, String patternString) {
		Pattern pattern = Pattern.compile(patternString, Pattern.DOTALL
				| Pattern.MULTILINE);
		Matcher matcher = pattern.matcher(sb);
		if (matcher.find()) {
			return matcher.group();
		}
		return null;
	}

	private int parseQuantity(String quantity) {
		return Integer.parseInt(quantity);
	}
}
