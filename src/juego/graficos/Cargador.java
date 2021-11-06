package juego.graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import juego.utils.Sonido;

public class Cargador {

	public static BufferedImage ImageLoader(String path) {
		try {
			URL url = Cargador.class.getResource(path);
			return ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
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