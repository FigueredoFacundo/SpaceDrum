package Juego.Graficos;

import java.awt.image.BufferedImage;

public class RecursosExternos {
	
	public static BufferedImage player;
	public static BufferedImage laser;
	public static void init() {
		player = Cargador.ImageLoader("/ships/jugador.png");
		laser = Cargador.ImageLoader("/ships/laserBlue01.png");
	}

}
