package org.amm.pc.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class JCHelper {

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
