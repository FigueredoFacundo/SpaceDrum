package juego.graficos;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MapBackground {
	public static ArrayList<BufferedImage> frames;
	public static int currentFrame = 0;
	public static int countOfFrames = 30;
	
	public static void init() {
		frames = new ArrayList<BufferedImage>(); 
		for (int j = 0; j < countOfFrames; j++) {
			frames.add(Cargador.ImageLoader("/background/frame_"+j+"_delay-0.03s.jpg"));	
		}
	}
	
	public static BufferedImage getFrame() {
		BufferedImage frame = frames.get(currentFrame);
		currentFrame++;
		currentFrame %= countOfFrames;
		return frame;
	}
}
