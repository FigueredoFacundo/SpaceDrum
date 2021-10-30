package Juego.Graficos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

import Juego.Logica.Mapa;
import Juego.input.KeyBoard;

public class VentanaPrincipal extends JFrame implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int ANCHO = 800;
	public static final int ALTO = 600;
	private Canvas canvas;
	private Thread hiloPrincipal;
	private boolean running = false;
	private BufferStrategy bs;
	private Graphics g;
	private final int FPS = 60;
	private final double TARGETTIME = 1000 / FPS;
	private double delta = 0;
	private int AVERAGEFPS = FPS;
	int x = 0;
	private Mapa mapa;
	private KeyBoard teclado;
	

	public VentanaPrincipal(Mapa mapa) {
		this.mapa = mapa;
		setTitle("Space run");
		setSize(ANCHO, ALTO);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		teclado = new KeyBoard();
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(ANCHO, ALTO));
		canvas.setMaximumSize(new Dimension(ANCHO, ALTO));
		canvas.setMinimumSize(new Dimension(ANCHO, ALTO));
		add(canvas);
		canvas.addKeyListener(teclado);
		init();
	}

	private void init() {
		RecursosExternos.init();

	}

	public void actualizar() {
		teclado.update();
		mapa.actualizar();
	}

	public void dibujar() {
		bs = canvas.getBufferStrategy();

		if (bs == null) {
			canvas.createBufferStrategy(2);
			return;
		}

		g = bs.getDrawGraphics();
		// zona dibujo-------------------------------------------------------------
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, ANCHO, ALTO);
		
		mapa.dibujar(g);
		
		

		// -------------------------------------------------------------

		g.dispose();
		bs.show();

	}

	@Override
	public void run() {
		long now = 0;
		long lastTime = System.nanoTime();
		int frames = 0;
		long time = 0;
		
		while (running) {

			now = System.nanoTime();
			delta += (now - lastTime) / TARGETTIME;
			lastTime = now;
			time+=(now-lastTime);
			if (delta >= 1) {
				actualizar();
				dibujar();
				delta--;
				frames++;
				
				

			}
			if (time >= 1000000000) {
				AVERAGEFPS=frames;
				frames = 0;
				time = 0;
			}
		}

		stop();
	}
	public void iniciar() {
		start();
	}
	private void start() {
		this.hiloPrincipal = new Thread(this);
		this.hiloPrincipal.start();
		running = true;
	}

	private void stop() {
		try {
			this.hiloPrincipal.wait();
			running = false;
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	

}