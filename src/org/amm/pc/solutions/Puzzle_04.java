package org.amm.pc.solutions;

import static org.amm.pc.JCConstants.Puzzle_04.PATTERN;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.amm.pc.utils.JCHelper;

/**
 * In file's of alphabetic characters find sequence of 
 * One small letter, surrounded by EXACTLY three big letters.
 *  Compose the word from this small letters.
 *
 * puzzle's url - http://www.pythonchallenge.com/pc/def/equality.html
 */
public class Puzzle_04 {

	/**
	 * Read one line from file than match with regular expression
	 * 
	 */
	public static String solution_0(String filename)
			throws FileNotFoundException {
		
		StringBuffer sb = new StringBuffer();
		Pattern pattern = Pattern.compile(PATTERN);

		Scanner input = new Scanner(new File(filename));
		while (input.hasNextLine()) {

			Matcher matcher = pattern.matcher(input.nextLine());
			while (matcher.find()) {
				sb.append(matcher.group(1));
			}
		}
		input.close();
		
		return sb.toString();
	}

	/**
	 * Match all file content with regular expression
	 * 
	 */
	public static String solution_1(String filename)
			throws FileNotFoundException {

		StringBuffer sb = new StringBuffer();
		Pattern pattern = Pattern.compile(PATTERN);
		Matcher matcher = pattern.matcher(JCHelper.getFileContent(filename));
		while (matcher.find()) {
			sb.append(matcher.group(1));
		}
		
		return sb.toString();
	}
}
