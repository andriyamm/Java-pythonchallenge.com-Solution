package org.amm.pc.solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Puzzle_03 {

	public static final String FILENAME = "ocr.txt";
	public static final String PATTERN = "[a-zA-Z]";
	public static final String ENCODING = "UTF-8";
	
	public static void main(String[] args) {
		try {
			File file = new File("ocr.txt");
			InputStream in = new FileInputStream(file);
			Reader reader = new InputStreamReader(in, Charset.forName(ENCODING));
			Reader buffer = new BufferedReader(reader);
			
			solution_01(buffer);
		} catch (Exception e) {
			//TODO
		}
		
		try {
			File file = new File("ocr.txt");
			InputStream in = new FileInputStream(file);
			Reader reader = new InputStreamReader(in, Charset.forName(ENCODING));
			Reader buffer = new BufferedReader(reader);
			
			solution_01(buffer);
		} catch (Exception e) {
			//TODO
		}
	}
	
	public static void solution_01(Reader reader) throws IOException {
		int readChar;
		StringBuffer sb = new StringBuffer();
		while ((readChar = reader.read()) != -1) {
			if (Character.isLetter(readChar))
				sb.append((char) readChar);
		}
		System.out.println(sb.toString());
	}

	public static void solution_02(String filename) throws FileNotFoundException {
		StringBuffer sb = new StringBuffer();
		Pattern pattern = Pattern.compile(PATTERN);

		Scanner input = new Scanner(new File(filename));
		while (input.hasNextLine()) {
			
			Matcher matcher = pattern.matcher(input.nextLine());
			while(matcher.find()){
				sb.append(matcher.group());
			}
		}
		System.out.println(sb.toString());
	}
	
	public static void solution_03(Reader reader) throws IOException{
		
		Map<Character, Integer> charecterCountMap = new HashMap<Character, Integer>();
		int readChar;
		while ((readChar = reader.read()) != -1) {
			Character ch = (char) readChar;
			
			if (!charecterCountMap.containsKey(ch)){
				charecterCountMap.put(ch, new Integer(1));
			}else{
				int i = charecterCountMap.get(ch);
				charecterCountMap.put(ch, new Integer(i));
			}
		}
		
	}
}
