package org.amm.pc.solutions;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

public class Puzzle_08 {

	public static void main(String[] args) {
		try {
			solution_0();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// TODO: load the image
	// TODO: read the image
	// TODO: get image width
	// TODO: get image height
	// TODO: get position of grey pixels
	// TODO: get pixel
	// TODO: check if red = green = blue

	public static void solution_0() throws IOException {
		
		File file = new File("oxygen.png");
		BufferedImage bi = ImageIO.read(file);

		int height = bi.getHeight()/2;
		int width = bi.getWidth();

		StringBuilder sb = new StringBuilder();

		for (int xx = 0; xx < width; xx=xx+7) {

			Color originalColor = new Color(bi.getRGB(xx, height));
			int r1 = originalColor.getRed();
			int g1 = originalColor.getGreen();
			int b1 = originalColor.getBlue();

			if (r1 == g1 && r1 == b1) {
				sb.append((char) r1);
			}
		}

		System.out.println(sb);

		int[] ar = new int[sb.length()];

		for (int i = 0; i < sb.length(); i++) {
			ar[i] = (char)sb.charAt(i);
		}

		System.out.println(ar.toString());

	}

}
