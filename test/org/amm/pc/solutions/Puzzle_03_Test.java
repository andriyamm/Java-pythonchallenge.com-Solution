package org.amm.pc.solutions;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class Puzzle_03_Test {
	
	public static final String FILENAME = "ocr.txt";
	public static final String ENCODING = "UTF-8";

	private Reader buffer;

	@Before
	public void solution() throws FileNotFoundException {
		File file = new File(FILENAME);
		InputStream in = new FileInputStream(file);
		Reader reader = new InputStreamReader(in, Charset.forName(ENCODING));
		buffer = new BufferedReader(reader);
	}

	@Test
	public void solution_1_test() throws IOException {
		assertEquals("equality", Puzzle_03.solution_01(buffer));
	}

	@Test
	public void solution_2_test() throws IOException {
		assertEquals("equality", Puzzle_03.solution_02(FILENAME));
	}

	@Test
	public void solution_3_test() throws IOException {
		assertEquals("equality", Puzzle_03.solution_03(buffer));
	}
	
	@Test
	public void countCharacters_test() throws IOException {
		
		assertEquals("equality", Puzzle_03.countCharacters(buffer));
	}
	
	@Test
	public void createRareCharactersString_test() throws IOException {
		Map<Character, Integer> characterCountMap = new LinkedHashMap<Character, Integer>();
		characterCountMap.put('c', 1);
		characterCountMap.put('{', 34);
		characterCountMap.put('a', 2);
		characterCountMap.put('$', 34);
		characterCountMap.put('b', 1);
		assertEquals("cb", Puzzle_03.createRareCharactersString(characterCountMap));
	}
}
