package Juego.Graficos;

import java.awt.image.BufferedImage;

public class RecursosExternos {
	
	public static BufferedImage player;
	public static BufferedImage enemigo;
	public static BufferedImage laser;
	public static BufferedImage laserRed;
	public static void init() {
		player = Cargador.ImageLoader("/ships/jugador.png");
		enemigo = Cargador.ImageLoader("/ships/ufo.png");
		laser = Cargador.ImageLoader("/ships/laserBlue01.png");
		laserRed = Cargador.ImageLoader("/ships/laserRed01.png");
	}

}
