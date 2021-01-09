package com.sunjun;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CaptionScreenUtil {

	
	/**
     * 指定屏幕区域截图，保存到指定目录
     * @param x
     * @param y
     * @param width
     * @param height
     * @param savePath - 文件保存路径
     * @param fileName - 文件保存名称
     * @param format - 文件格式
     */
    public static void screenShotAsFile(int x, int y, int width, int height, String savePath, String fileName, String format) {
        try {
            Robot robot = new Robot();
            BufferedImage bfImage = robot.createScreenCapture(new Rectangle(x, y, width, height));
            File path = new File(savePath);
            File file = new File(path, fileName+ "." + format);
            ImageIO.write(bfImage, format, file);
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
}
