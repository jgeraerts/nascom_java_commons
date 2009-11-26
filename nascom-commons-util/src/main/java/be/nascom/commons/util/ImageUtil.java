package be.nascom.commons.util;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * User: jgeraerts
 * Date: Nov 25, 2009
 * Time: 4:55:30 PM
 */
public class ImageUtil {


    public static BufferedImage scaleImage(BufferedImage image, int p_width, int p_height) {
        int thumbWidth = p_width;
        int thumbHeight = p_height;

        // Make sure the aspect ratio is maintained, so the image is not skewed
        double thumbRatio = (double) thumbWidth / (double) thumbHeight;
        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);
        double imageRatio = (double) imageWidth / (double) imageHeight;
        if (thumbRatio < imageRatio) {
            thumbHeight = (int) (thumbWidth / imageRatio);
        } else {
            thumbWidth = (int) (thumbHeight * imageRatio);
        }

        // Draw the scaled image
        BufferedImage thumbImage = new BufferedImage(thumbWidth,
                thumbHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = thumbImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.drawImage(image, 0, 0, thumbWidth, thumbHeight, null);
        return thumbImage;
    }
}
