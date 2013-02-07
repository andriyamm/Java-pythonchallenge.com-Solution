package org.amm.pc.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class JCFileHelper {

	/**
	 * Unzip folder
	 * 
	 * @param zipFile
	 *            input zip file
	 * @param output
	 *            zip output folder
	 */
	public static void unZipIt(String zipFile, String outputFolder) {

		byte[] buffer = new byte[1024];

		try {
			// create output directory is not exists
			File folder = new File(outputFolder);
			if (!folder.exists()) {
				folder.mkdir();
			}
			
			// get the zip file content
			ZipInputStream zipInputStream = new ZipInputStream(
					new FileInputStream(zipFile));
			
			// get the zipped file list entry
			ZipEntry zipEntry = zipInputStream.getNextEntry();
			
			while (zipEntry != null) {

				String fileName = zipEntry.getName();
				File newFile = new File(outputFolder + File.separator
						+ fileName);
			
				// create all non exists folders
				// else you will hit FileNotFoundException for compressed folder
				new File(newFile.getParent()).mkdirs();

				FileOutputStream fos = new FileOutputStream(newFile);

				int len;
				while ((len = zipInputStream.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}

				fos.close();
				zipEntry = zipInputStream.getNextEntry();
			}

			zipInputStream.closeEntry();
			zipInputStream.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
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

}
