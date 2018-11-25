package code;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageHelper {
    private BufferedImage readImage(String filename) throws IOException {
        File input = new File(filename);
        BufferedImage image = ImageIO.read(input);
        return image;
    }

    /**
     * This method creates histogram from an image. Adapted as necessary 
     * from http://developer.bostjan-cigan.com/java-image-binarization/
     */
    private int[] imageHistogram(BufferedImage input) {
        int[] histogram = new int[256];

        for (int i = 0; i < histogram.length; i++) histogram[i] = 0;

        for (int i = 0; i < input.getWidth(); i++) {
            for (int j = 0; j < input.getHeight(); j++) {
                int red = new Color(input.getRGB(i, j)).getRed();
                histogram[red]++;
            }
        }
        return histogram;
    }

    /**
     * This method determine a threshold for binarization using otsu method. 
     * Adapted as necessary from http://developer.bostjan-cigan.com/java-image-binarization/
     */
    private int otsuTreshold(BufferedImage original) {

        int[] histogram = imageHistogram(original);
        int total = original.getHeight() * original.getWidth();

        float sum = 0;
        for (int i = 0; i < 256; i++) sum += i * histogram[i];

        float sumB = 0;
        int wB = 0;
        int wF = 0;

        float varMax = 0;
        int threshold = 0;

        for (int i = 0; i < 256; i++) {
            wB += histogram[i];
            if (wB == 0) continue;
            wF = total - wB;

            if (wF == 0) break;

            sumB += (float) (i * histogram[i]);
            float mB = sumB / wB;
            float mF = (sum - sumB) / wF;

            float varBetween = (float) wB * (float) wF * (mB - mF) * (mB - mF);

            if (varBetween > varMax) {
                varMax = varBetween;
                threshold = i;
            }
        }
        return threshold;

    }

    /**
     * This method converts an image into its binary representation, where 
     * dark pixel in the image is represented as 1 in the output matrix. In contrast, 
     * white pixel in the image is converted into 0 in the output matrix.
     */
    public int[][] getBinary(String filename) throws IOException {
        BufferedImage image = readImage(filename);
        int threshold = otsuTreshold(image);
        int w = image.getWidth();
        int h = image.getHeight();
        Raster raster = image.getData();
        int[][] binaryImg = new int[w][h];
        int grayscale;
        for (int j = 0; j < w; j++) {
            for (int k = 0; k < h; k++) {
                grayscale = raster.getSample(j, k, 0);
                if (grayscale > threshold)
                    binaryImg[j][k] = -1;
                else
                    binaryImg[j][k] = 1;
            }
        }
        return binaryImg;
    }

    public void show(int[][] imageMatrix) {
        JFrame frame = new JFrame();
        int width = imageMatrix.length;
        int height = imageMatrix[0].length;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster raster = img.getRaster();
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                raster.setSample(i, j, 0, (imageMatrix[i][j] * 255));
        ImageIcon icon = new ImageIcon(img);
        JLabel label = new JLabel(icon);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}