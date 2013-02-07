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

import org.amm.pc.utils.JCFileHelper;

/**
 * find rare characters in the file 
 *
 * puzzle's url - http://www.pythonchallenge.com/pc/def/ocr.html
 */
public class Puzzle_03 {

	/**
	 * Read file Character by character and check if character is letter.
	 * 
	 * @param reader
	 * @return
	 * @throws IOException
	 */
	public static String solution_01(Reader reader) throws IOException {
		int readChar;
		StringBuffer sb = new StringBuffer();
		while ((readChar = reader.read()) != -1) {
			if (Character.isLetter(readChar))
				sb.append((char) readChar);
		}
		return sb.toString();
	}

	/**
	 * Read file line by line and check line with regular expression
	 * 
	 * @param filename
	 * @return
	 * @throws FileNotFoundException
	 */
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

	/**
	 * check all file's content with regular expression
	 * 
	 * @param filename
	 * @return
	 * @throws FileNotFoundException
	 */
	public static String solution_3(String filename)
			throws FileNotFoundException {
		
		StringBuffer sb = new StringBuffer();
		Pattern pattern = Pattern.compile(PATTERN);
		Matcher matcher = pattern.matcher(JCFileHelper.getFileContent(filename));
		while (matcher.find()) {
			sb.append(matcher.group());
		}
		return sb.toString();
	}
	
	/**
	 * Create Map where key is character, value character count 
	 * then Create String with Rare characters
	 * 
	 * @param reader
	 * @return
	 * @throws IOException
	 */
	public static String solution_4(Reader reader) throws IOException {
		return createRareCharactersString(countCharacters(reader));
	}
	
	/**
	 * Create Map where key is character, value character count 
	 * 
	 * @param reader
	 * @return
	 * @throws IOException
	 */
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
	
	/**
	 * Create String with Rare characters
	 * 
	 * @param characterCountMap
	 * @return
	 */
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
