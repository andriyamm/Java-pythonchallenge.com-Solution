package org.amm.pc.solutions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.amm.pc.utils.JCHelper;
import org.apache.commons.io.FileUtils;

public class Puzzle_07 {

	List<String> fileList;
	private static final String INPUT_ZIP_FILE = "D:\\workspace-git\\freezing-dangerzone\\puzzle_07.zip";
	private static final String OUTPUT_FOLDER = "D:\\workspace-git\\freezing-dangerzone\\puzzle_07";
	private static final String URL_STRING = "http://www.pythonchallenge.com/pc/def/channel.zip";
	public static final String PATTERN = "and the next nothing is (\\d+)";
	public static final String FIRST_NOTHING = "90052";
	
	private Map<String, String> nameToCommentMap = new HashMap<String, String>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// UnZip unZip = new UnZip();
		// unZip.unZipIt(INPUT_ZIP_FILE, OUTPUT_FOLDER);
	}

	public void solution_0() throws IOException {
		
		URL url = new URL(URL_STRING);
		File file = new File(INPUT_ZIP_FILE);
		
		FileUtils.copyURLToFile(url, file);
		unZipIt(INPUT_ZIP_FILE, OUTPUT_FOLDER);

		
	}

	public void create() throws FileNotFoundException{
		
		StringBuilder sb = new StringBuilder();
		String fileName = null;
		
		fileName = nextNothing(FIRST_NOTHING);
		sb.append(nameToCommentMap.get(fileName));
		
		while(fileName != null){
			fileName = nextNothing(FIRST_NOTHING);
			sb.append(nameToCommentMap.get(fileName));
		}
	}
	
	public void printResult(){
		//TODO
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
	 * @throws FileNotFoundException 
	 */
	public String nextNothing(String fileName) throws FileNotFoundException {
//		File file = new File(OUTPUT_FOLDER + File.separator
//				+ fileName);
		
		String fileContent = JCHelper.getFileContent(OUTPUT_FOLDER + File.separator
				+ fileName).toString();
		
		Pattern pattern = Pattern.compile(PATTERN);
		if (fileContent != null) {
			Matcher matcher = pattern.matcher(fileContent);
			if (matcher.find()) {
				return matcher.group(1);
			}
		}
		return null;
	}

	
	/**
	 * Unzip it
	 * 
	 * @param zipFile
	 *            input zip file
	 * @param output
	 *            zip file output folder
	 */
	public  void unZipIt(String zipFile, String outputFolder) {

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
			ZipEntry zipEntry = zis.getNextEntry();
			
			while (zipEntry != null) {

				String fileName = zipEntry.getName();
				File newFile = new File(outputFolder + File.separator
						+ fileName);

				//
				nameToCommentMap.put(fileName, zipEntry.getComment());
				
				// create all non exists folders
				// else you will hit FileNotFoundException for compressed folder
				new File(newFile.getParent()).mkdirs();

				FileOutputStream fos = new FileOutputStream(newFile);

				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}

				fos.close();
				zipEntry = zis.getNextEntry();
			}

			zis.closeEntry();
			zis.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
