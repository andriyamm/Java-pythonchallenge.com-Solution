package org.amm.pc.solutions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;

public class Puzzle_09 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {


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
	
	public static void solution_0(){
		
	}
}
