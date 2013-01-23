package org.amm.pc.solutions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;

public class Puzzle_09 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		//String un = "BZh91AY&SYA\xaf\x82\r\x00\x00\x01\x01\x80\x02\xc0\x02\x00 \x00!\x9ah3M\x07<]\xc9\x14\xe1BA\x06\xbe\x084";
		//String pw = "BZh91AY&SY\x94$|\x0e\x00\x00\x00\x81\x00\x03$ \x00!\x9ah3M\x13<]\xc9\x14\xe1BBP\x91\xf08";
			
		FileInputStream in = new FileInputStream("un.txt.bz2");
		FileOutputStream out = new FileOutputStream("un.txt");
		BZip2CompressorInputStream bzIn = new BZip2CompressorInputStream(in);
		final byte[] buffer = new byte[1024];
		int n = 0;
		while (-1 != (n = bzIn.read(buffer))) {
			out.write(buffer, 0, n);
		}
		out.close();
		bzIn.close();

	}
}
