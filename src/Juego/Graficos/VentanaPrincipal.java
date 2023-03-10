package Juego.Graficos;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import Juego.Logica.Mapa;
import Juego.Utils.Constantes;
import Juego.input.KeyBoard;

public class VentanaPrincipal extends JFrame implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	boolean partidaIniciada = false;
	boolean partidaTerminada = false;
	boolean partidaPausada = false;

	public VentanaPrincipal(Mapa mapa) {
		this.mapa = mapa;
		setTitle("Space run");
		setSize(Constantes.ANCHO_PANTALLA, Constantes.ALTO_PANTALLA);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		teclado = new KeyBoard();
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(Constantes.ANCHO_PANTALLA, Constantes.ALTO_PANTALLA));
		canvas.setMaximumSize(new Dimension(Constantes.ANCHO_PANTALLA, Constantes.ALTO_PANTALLA));
		canvas.setMinimumSize(new Dimension(Constantes.ANCHO_PANTALLA, Constantes.ALTO_PANTALLA));
		add(canvas);
		canvas.addKeyListener(teclado);
		init();
	}

	private void init() {
		RecursosExternos.init();
		BackGroundGIf.init();
		LifeBarGif.init();
	}

	@Override
	public void run() {
		long now = 0;
		long lastTime = System.nanoTime();
		int frames = 0;
		long time = 0;
		long paused = 0;
		long backgroundDelay = 0;
		
		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / TARGETTIME;
			lastTime = now;
			time+=(now-lastTime);
			
			if (delta >= 1) {
				if (KeyBoard.P && frames > paused +120) {
					this.partidaPausada = !this.partidaPausada;
					paused = frames;
				}
				teclado.update();
				
				
				bs = canvas.getBufferStrategy();
				while (bs == null) {
					canvas.createBufferStrategy(2);
					bs = canvas.getBufferStrategy();
				}

				g = bs.getDrawGraphics();
				
				
				// zona dibujo-------------------------------------------------------------
				if (frames > backgroundDelay +30 && !this.partidaPausada) {
					g.drawImage(BackGroundGIf.getFrame(), 0, 0, Constantes.ANCHO_PANTALLA, Constantes.ALTO_PANTALLA, null);
					backgroundDelay = frames;
				}

				if (KeyBoard.SPACE && !this.partidaIniciada) {
					this.partidaIniciada = true;
				}
				
				if(!this.partidaIniciada) {
					 g.drawImage(RecursosExternos.startPoster, Constantes.ANCHO_PANTALLA/3, Constantes.ALTO_PANTALLA*3/4,260,30, null);	
				}
				if(this.partidaIniciada && !partidaTerminada) {
					mapa.dibujar(g);
					if(!this.partidaPausada) {
						this.partidaTerminada = !mapa.actualizar();
					}else {
						g.drawImage(RecursosExternos.stopPoster, Constantes.ANCHO_PANTALLA/3, Constantes.ALTO_PANTALLA*3/4,260,30, null);
					}			
				}
				if(partidaTerminada) {
					g.drawImage(RecursosExternos.endPoster, Constantes.ANCHO_PANTALLA/3, Constantes.ALTO_PANTALLA*2/3,260,90, null);			
				}
				
				
				System.out.println(AVERAGEFPS);
				// -------------------------------------------------------------

				g.dispose();
				bs.show();

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