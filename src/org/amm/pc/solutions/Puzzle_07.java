package org.amm.pc.solutions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.FileUtils;

public class Puzzle_07 {

	List<String> fileList;
	private static final String INPUT_ZIP_FILE = "D:\\workspace-git\\freezing-dangerzone\\puzzle_07.zip";
	private static final String OUTPUT_FOLDER = "D:\\workspace-git\\freezing-dangerzone\\puzzle_07";
	private static final String URL_STRING = "http://www.pythonchallenge.com/pc/def/channel.zip";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// UnZip unZip = new UnZip();
		// unZip.unZipIt(INPUT_ZIP_FILE, OUTPUT_FOLDER);
	}

	public static void solution_0() throws IOException {
		URL url = new URL(URL_STRING);
		File file = new File(INPUT_ZIP_FILE);
		FileUtils.copyURLToFile(url, file);
		unZipIt(INPUT_ZIP_FILE, OUTPUT_FOLDER);
	}

	/**
	 * find readme.txt
	 * and get first nothing
	 */
	public void firstNothing() {
		// TODO
		
		
	}

	/**
	 * find file with name of nothing
	 * open it
	 * get next nothing
	 */
	public void nextNothing() {
		// TODO
	}

	/**
	 * Unzip it
	 * 
	 * @param zipFile
	 *            input zip file
	 * @param output
	 *            zip file output folder
	 */
	public static void unZipIt(String zipFile, String outputFolder) {

		byte[] buffer = new byte[1024];

		try {

			// create output directory is not exists
			File folder = new File(OUTPUT_FOLDER);
			if (!folder.exists()) {
				folder.mkdir();
			}

			// get the zip file content
			ZipInputStream zis = new ZipInputStream(
					new FileInputStream(zipFile));
			// get the zipped file list entry
			ZipEntry ze = zis.getNextEntry();

			while (ze != null) {

				String fileName = ze.getName();
				File newFile = new File(outputFolder + File.separator
						+ fileName);

				System.out.println("file unzip : " + newFile.getAbsoluteFile());

				// create all non exists folders
				// else you will hit FileNotFoundException for compressed folder
				new File(newFile.getParent()).mkdirs();

				FileOutputStream fos = new FileOutputStream(newFile);

				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}

				fos.close();
				ze = zis.getNextEntry();
			}

			zis.closeEntry();
			zis.close();

			System.out.println("Done");

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
