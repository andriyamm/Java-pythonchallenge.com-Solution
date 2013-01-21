package org.amm.pc.solutions;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.amm.pc.utils.JCHelper;

public class Puzzle_06 {

	public static final String PATTERN_PAIR_ARRAY = "(lp(.+)aa";
	public static final String PATTERN_PAIR = "(g(.+)a";
	public static final String PATTERN_QUANTITY = "(I(\\d+)";
	public static final String PATTERN_CHARACTER = "g(\\d)";
	public static final String FILENAME = "peak.txt";

	private class Pair {
		private String character;
		private int quantity;

		public Pair(String character, int quantity) {
			this.character = character;
			this.quantity = quantity;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < quantity; i++) {
				sb.append(character);
			}

			return sb.toString();
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

	private void printBanner(List<ArrayList<Pair>> banner) {
		for (ArrayList<Pair> listPair : banner) {
			for (Pair pair : listPair) {
				System.out.print(pair.toString());
			}
			System.out.println();
		}
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
