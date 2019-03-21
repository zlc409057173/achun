package com.clear2pay.cn.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class Test {
	private static int WIDTH = 140;
	private static int HEIGHT = 30;
	private static String[] str = {"A","a","B","b","C","c","D","d","E","e","F","f","G","g","H","h","I","i",
			"J","j","K","k","L","l","M","m","N","n","O","o","P","p","Q","q","R","r","S","s","T","t",
			"U","u","V","v","W","w","X","x","Y","y","Z","z","1","2","3","4","5","6","7","8","9","0"};
	public static void main(String[] args) {
		try{
			File file = new File("E:\\aa.jpg");
			FileOutputStream fos = new FileOutputStream(file);
			BufferedImage img = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
			StringBuffer code = new StringBuffer();
			Random r = new Random();
			for (int i = 1; i <= 6; i++) {
				int index = r.nextInt(str.length);
				code.append(str[index]+" ");
			}
			Graphics g = img.getGraphics();
			g.setColor(Color.BLACK);
			g.drawRect(0, 0, WIDTH, HEIGHT);
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			g.setColor(Color.RED);
			g.setFont(new Font("宋体", Font.BOLD, 20));
			g.drawString(code.toString(), 10,22);
			g.setColor(Color.YELLOW);
//			g.drawLine(10, 5, 130, 25);
			for(int i=0;i<=330;i++){
				int x = r.nextInt(WIDTH);
				int y = r.nextInt(HEIGHT);
				g.drawLine(x, y, x, y);
			}
			ImageIO.write(img, "jpg", fos);
			fos.flush();
			fos.close();
		}catch(Exception e){
		}
	}
}
