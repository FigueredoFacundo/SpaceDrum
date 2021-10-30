package Juego.Graficos;

import java.awt.image.BufferedImage;
import Juego.Utils.Sonido;

public class RecursosExternos {

	public static BufferedImage player;
	public static BufferedImage enemigo;
	public static BufferedImage laser;
	public static BufferedImage laserRed;
	public static Sonido shoot;
	public static Sonido explosion;

	public static BufferedImage endPoster;
	public static BufferedImage startPoster;
	public static BufferedImage stopPoster;
	
	public static void init() {
		player = Cargador.ImageLoader("/ships/jugador.png");
		enemigo = Cargador.ImageLoader("/ships/ufo.png");
		laser = Cargador.ImageLoader("/ships/laserBlue01.png");
		startPoster = Cargador.ImageLoader("/posters/startPoster.png");
		stopPoster = Cargador.ImageLoader("/posters/stopPoster.png");
		endPoster = Cargador.ImageLoader("/posters/endPoster.png");
		laserRed = Cargador.ImageLoader("/ships/laserRed01.png");
		shoot = Cargador.SoundLoader("/sound/laser.wav");
		explosion = Cargador.SoundLoader("/sound/explosion.wav");
		shoot.setVolume(0.35f);
		explosion.setVolume(0.2f);
	}
}
