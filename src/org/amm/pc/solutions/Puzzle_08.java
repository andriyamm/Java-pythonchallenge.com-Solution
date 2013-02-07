package org.amm.pc.solutions;

import static org.amm.pc.JCConstants.Puzzle_08.PATTERN;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.amm.pc.utils.JCHelper;
import org.apache.commons.io.FileUtils;

public class Puzzle_08 {

	public static void main(String[] args) {
		
	}

	// TODO: load the image
	// TODO: read the image
	// TODO: get image width
	// TODO: get image height
	// TODO: get position of grey pixels
	// TODO: get pixel
	// TODO: check if red = green = blue

	public StringBuilder solution_0(String filename) throws IOException {

		File file = new File(filename);
		BufferedImage bi = ImageIO.read(file);

		int grayPixelHeightPosition = bi.getHeight() / 2;
		int imageWidth = bi.getWidth();
		int red = 0, green = 0, blue = 0;

		StringBuilder sb = new StringBuilder();

		for (int pixel = 0; pixel < imageWidth; pixel = pixel + 7) {

			Color originalColor = new Color(bi.getRGB(pixel, grayPixelHeightPosition));

			red = originalColor.getRed();
			green = originalColor.getGreen();
			blue = originalColor.getBlue();

			if (red == green && red == blue) {
				sb.append((char) red);
			}

		}
		
		return findResult(sb);
	}

	public StringBuilder findResult(StringBuilder sb) {

		StringBuilder result = new StringBuilder();
		Pattern pattern = Pattern.compile(PATTERN);
		if (sb != null) {
			Matcher matcher = pattern.matcher(sb);
			while (matcher.find()) {
				result.append((char) Integer.parseInt(matcher.group()));
			}
		}
		return result;
	}

}
