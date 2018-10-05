package com.unionbank.core;

import java.io.IOException;

import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ImageUtils {

    /**
     * Decode string to image
     * @param imageString The string to decode
     * @return decoded image
     */
    public static BufferedImage decodeToImage(String imageString) {

        BufferedImage image = null;
        byte[] imageByte;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

    /**
     * Encode image to string
     * @param image The image to encode
     * @param type jpeg, bmp, ...
     * @return encoded string
     */
    public static String encodeToString(BufferedImage image, String type) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();

            BASE64Encoder encoder = new BASE64Encoder();
            imageString = encoder.encode(imageBytes);

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }

    public static void main (String args[]) throws IOException {
        /* Test image to string and string to image start */
       // BufferedImage img = ImageIO.read(new File("files/img/TestImage.png"));
       BufferedImage newImg;
       String imgstr="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";
        //imgstr = encodeToString(img, "png");
       // System.out.println(imgstr);
        newImg = decodeToImage(imgstr);
      //  ImageIO.write(newImg, "png", new File("files/img/CopyOfTestImage.png"));
        ImageIO.write(newImg, "png", new File("C:/Users/aajibade/Documents/BVN_link_update/keys/photo/CopyOfTestImage.png"));
        //C:/Users/aajibade/Documents/BVN_link_update/keys/photo
        /* Test image to string and string to image finish */
    }
}