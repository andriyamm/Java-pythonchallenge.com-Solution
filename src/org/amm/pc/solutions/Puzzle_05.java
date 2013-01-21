package org.amm.pc.solutions;

import static org.amm.pc.JCConstants.Puzzle_05.PATTERN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Puzzle_05 {

	public static String solution_0(String urlString) {

		BufferedReader buffer = null;
		String urlStringWithNothing = null;
		String inputLine = null;
		String nothing = null;
		String nothing_prev = "63579";
		
		try {
			while (true) {
				urlStringWithNothing = urlString + nothing_prev;
				URL url = new URL(urlStringWithNothing);
				buffer = new BufferedReader(new InputStreamReader(
						url.openStream()));

				while ((inputLine = buffer.readLine()) != null) {
					nothing = nextNothing(inputLine);
					if (nothing == null) {
						return nothing_prev;
					}
					nothing_prev = nothing;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (buffer != null) {
				try {
					buffer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	private static String nextNothing(String content) {

		Pattern pattern = Pattern.compile(PATTERN);
		if (content != null) {
			Matcher matcher = pattern.matcher(content);
			if (matcher.find()) {
				return matcher.group(1);
			}
		}
		return null;
	}
}
