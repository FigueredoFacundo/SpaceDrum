package Juego.Graficos;

import java.awt.image.BufferedImage;
import Juego.Utils.Sonido;

public class RecursosExternos {

	public static BufferedImage player;
	public static BufferedImage enemigo;
	public static BufferedImage enemigo2;
	public static BufferedImage enemigo3;
	public static BufferedImage enemigo4;
	public static BufferedImage laser;
	public static BufferedImage laserRed;
	public static BufferedImage [] exp = new BufferedImage[9];
	public static Sonido shoot;
	public static Sonido explosion;

	public static BufferedImage endPoster;
	public static BufferedImage startPoster;
	public static BufferedImage stopPoster;
	

	public static void init() {
		player = Cargador.ImageLoader("/ships/jugador.png");
		enemigo = Cargador.ImageLoader("/ships/ufo.png");
		enemigo2 = Cargador.ImageLoader("/ships/ufoBlue.png");
		enemigo3 = Cargador.ImageLoader("/ships/ufoGreen.png");
		enemigo4 = Cargador.ImageLoader("/ships/ufoYellow.png");
		laser = Cargador.ImageLoader("/ships/laserBlue01.png");
		startPoster = Cargador.ImageLoader("/posters/startPoster.png");
		stopPoster = Cargador.ImageLoader("/posters/stopPoster.png");
		endPoster = Cargador.ImageLoader("/posters/endPoster.png");
		laserRed = Cargador.ImageLoader("/ships/laserRed01.png");

		for(int i = 0;i<exp.length;i++) {
			exp[i]= Cargador.ImageLoader("/explosion/"+i+".png");
		}

		shoot = Cargador.SoundLoader("/sound/laser.wav");
		explosion = Cargador.SoundLoader("/sound/explosion.wav");
		shoot.setVolume(0.35f);
		explosion.setVolume(0.2f);
	}
}
