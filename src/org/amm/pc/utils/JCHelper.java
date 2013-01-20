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

public class JCHelper {

	public static void handleFile(File file, Charset encoding)
			throws IOException {

		InputStream inputStream = null;
		Reader reader = null;
		Reader buffer = null;

		try {
			inputStream = new FileInputStream(file);
			reader = new InputStreamReader(inputStream, encoding);
			buffer = new BufferedReader(reader);
			handleCharacters(buffer);
		} catch (Exception e) {

		} finally {
			inputStream.close();
			reader.close();
			buffer.close();
		}
	}

	private static void handleCharacters(Reader reader) throws IOException {
		int r;
		while ((r = reader.read()) != -1) {
			char ch = (char) r;
			System.out.println("Do something with " + ch);
		}
	}

	/**
	 * Get file content to StringBuffer
	 * 
	 * @param filename
	 * @return
	 * @throws FileNotFoundException
	 */
	public static StringBuffer getFileContent(String filename)
			throws FileNotFoundException {

		StringBuffer sb = new StringBuffer();
		Scanner input = new Scanner(new File(filename));
		while (input.hasNextLine()) {
			sb.append(input.nextLine());
		}
		input.close();

		return sb;
	}

	public static void main(String urlString) {

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
