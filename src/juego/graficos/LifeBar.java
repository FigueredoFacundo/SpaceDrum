package juego.graficos;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class LifeBar {
	public static ArrayList<BufferedImage> frames;
	public static int countOfFrames = 6;
	
	public static void init() {
		frames = new ArrayList<BufferedImage>(); 
		for (int j = 0; j < countOfFrames; j++) {
			frames.add(Cargador.ImageLoader("/lifeBar/"+j+".png"));	
		}
	}
	
	public static BufferedImage getFrame(double actualLife, double maxLife) {
		double frameNumber = actualLife*(countOfFrames-1)/maxLife;
		BufferedImage frame = frames.get((int)frameNumber);
		return frame;
	}
}
