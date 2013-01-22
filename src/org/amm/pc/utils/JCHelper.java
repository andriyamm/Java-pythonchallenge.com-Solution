package org.amm.pc.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JCHelper {

	/**
	 * Methods read file character by character
	 * 
	 * @param file
	 *            file what will be read
	 * @param encoding
	 *            file encoding
	 * @throws IOException
	 */
	public static void handleFile(File file, Charset encoding)
			throws IOException {

		InputStream inputStream = null;
		Reader reader = null;
		Reader buffer = null;

		try {
			inputStream = new FileInputStream(file);
			reader = new InputStreamReader(inputStream, encoding);
			buffer = new BufferedReader(reader);

			int r;
			while ((r = buffer.read()) != -1) {
				char ch = (char) r;
				System.out.println("Do something with " + ch);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			inputStream.close();
			reader.close();
			buffer.close();
		}
	}

	/**
	 * Get file content to StringBuilder
	 * 
	 * @param filename
	 * 			file what will be read
	 * @return 
	 * 		stringbuilder object with file contents
	 * @throws FileNotFoundException
	 */
	public static StringBuilder getFileContent(String filename)
			throws FileNotFoundException {

		StringBuilder sb = new StringBuilder();
		Scanner input = new Scanner(new File(filename));
		while (input.hasNextLine()) {
			sb.append(input.nextLine());
		}
		input.close();

		return sb;
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
	 * method print a content of web page
	 * 
	 * @param urlString
	 *            web page address
	 */
	public static void printWebPageContent(String urlString) {

		BufferedReader buffer = null;
		try {
			URL url = new URL(urlString);
			buffer = new BufferedReader(new InputStreamReader(url.openStream()));

			String inputLine;
			while ((inputLine = buffer.readLine()) != null) {
				System.out.println(inputLine);
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
	}
}
