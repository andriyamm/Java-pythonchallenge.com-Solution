package org.amm.pc.solutions;

import static org.amm.pc.JCConstants.Puzzle_03.PATTERN;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Puzzle_03 {

	public static String solution_01(Reader reader) throws IOException {
		int readChar;
		StringBuffer sb = new StringBuffer();
		while ((readChar = reader.read()) != -1) {
			if (Character.isLetter(readChar))
				sb.append((char) readChar);
		}
		return sb.toString();
	}

	public static String solution_02(String filename)
			throws FileNotFoundException {
		StringBuffer sb = new StringBuffer();
		Pattern pattern = Pattern.compile(PATTERN);

		Scanner input = new Scanner(new File(filename));
		while (input.hasNextLine()) {

			Matcher matcher = pattern.matcher(input.nextLine());
			while (matcher.find()) {
				sb.append(matcher.group());
			}
		}
		return sb.toString();
	}

	public static String solution_03(Reader reader) throws IOException {
		return createRareCharactersString(countCharacters(reader));
	}
	
	public static Map<Character, Integer> countCharacters(Reader reader) throws IOException{
		Map<Character, Integer> characterCountMap = new LinkedHashMap<Character, Integer>();
		int readChar;
		while ((readChar = reader.read()) != -1) {
			Character ch = (char) readChar;

			if (!characterCountMap.containsKey(ch)) {
				characterCountMap.put(ch, new Integer(1));
			} else {
				int i = characterCountMap.get(ch) + 1;
				characterCountMap.put(ch, new Integer(i));
			}
		}
		return characterCountMap;
	}
	
	public static String createRareCharactersString(Map<Character, Integer> characterCountMap){
		StringBuffer sb = new StringBuffer();
		for(Entry<Character, Integer> entry: characterCountMap.entrySet()){
			if(entry.getValue() == 1){
				sb.append(entry.getKey());
			}
		}
		
		return sb.toString();
	}
}
