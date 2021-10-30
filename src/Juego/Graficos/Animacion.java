package Juego.Graficos;

import java.awt.image.BufferedImage;

import Juego.Utils.Circulo;

public class Animacion {
	private BufferedImage[] frames;
	private int velocidad;
	private int index;
	private boolean running;
	private Circulo posicion;
	private long time, lastTime;

	public Animacion(BufferedImage[] frames, int velocidad, Circulo posicion) {
		this.frames = frames;
		this.velocidad = velocidad;
		this.posicion = posicion;
		index = 0;
		running = true;
		time = 0;
		lastTime = System.currentTimeMillis();

	}

	public void update() {
		time += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(time>velocidad) {
			time = 0;
			index++;
			if(index>=frames.length) {
				running = false;
			}
		}
	}
	public boolean isRunning() {
		return running;
	}
	public Circulo getPosicion() {
		return posicion;
	}
	public BufferedImage getCurrentFrame() {
		return frames[index];
	}

}
