package Juego.Graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Juego.Utils.Sonido;

public class Cargador {

	public static BufferedImage ImageLoader(String path) {
		try {
			return ImageIO.read(Cargador.class.getResource(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("xd");
		}
		System.out.println("lol");
		return null;
	}

	public static Sonido SoundLoader(String path) {
		try {
			return new Sonido(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}