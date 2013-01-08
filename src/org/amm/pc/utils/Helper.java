package org.amm.pc.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

public class Helper {

	public static void handleFile(File file, Charset encoding)
			throws IOException {
		try {
			InputStream in = new FileInputStream(file);
			Reader reader = new InputStreamReader(in, encoding);
			Reader buffer = new BufferedReader(reader);
			handleCharacters(buffer);
		} catch (Exception e) {

		}
	}

	private static void handleCharacters(Reader reader) throws IOException {
		int r;
		while ((r = reader.read()) != -1) {
			char ch = (char) r;
			System.out.println("Do something with " + ch);
		}
	}

}
