package org.amm.pc.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JCRegexpHelper {

	/**
	 * 
	 * 
	 * @param content
	 * 
	 * @param regexprPattern
	 *            regular expression pattern string
	 * @param groupNumber
	 *            int number of group
	 * @return
	 */
	public static String find(String content, String regexprPattern,
			int groupNumber) {

		Pattern pattern = Pattern.compile(regexprPattern);
		if (content != null) {
			Matcher matcher = pattern.matcher(content);
			if (matcher.find()) {
				return matcher.group(groupNumber);
			}
		}
		return null;
	}

	/**
	 * 
	 * 
	 * @param content
	 * 
	 * @param regexprPattern
	 *            regular expression pattern string
	 * @param groupNumber
	 *            int number of group
	 * @return
	 */
	public static List<String> findAll(String content, String regexprPattern,
			int groupNumber) {

		List<String> allMatches = new ArrayList<String>();
		
		Pattern pattern = Pattern.compile(regexprPattern);
		if (content != null) {
			Matcher matcher = pattern.matcher(content);
			while (matcher.find()) {
				allMatches.add(matcher.group(groupNumber));
			}
		}
		return allMatches;
	}

}
