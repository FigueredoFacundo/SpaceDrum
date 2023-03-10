package Juego.Logica;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import Juego.Entidades.Darius;
import Juego.Entidades.Enemigo;
import Juego.Entidades.EntidadAbstracta;
import Juego.Entidades.Proyectil;
import Juego.Graficos.Animacion;
import Juego.Graficos.RecursosExternos;
import Juego.Utils.Circulo;
import Juego.Utils.Constantes;
import Juego.Utils.Cronometro;
import Juego.Utils.Punto;
import Juego.input.KeyBoard;

public class Mapa {
	ArrayList<Enemigo> enemigosEnPantalla = new ArrayList<Enemigo>();
	ArrayList<Darius> dariusEnPantalla = new ArrayList<Darius>();
	ArrayList<Proyectil> proyectilesEnemigos = new ArrayList<Proyectil>();
	ArrayList<Proyectil> proyectilesAliados = new ArrayList<Proyectil>();
	ArrayList<Enemigo> bufferEnemigos = new ArrayList<Enemigo>();
	ArrayList<Animacion> exp = new ArrayList<Animacion>();
	Cronometro firerate;
	Cronometro cd;
	Cronometro enemigoFireRate;

	public Mapa() {
		dariusEnPantalla.add(new Darius(1000, new Circulo(new Punto(20, 50), 28), 1,
				new Proyectil(new Circulo(new Punto(20, 20), 1), 1, RecursosExternos.laser), RecursosExternos.player));

		/*dariusEnPantalla.add(new Darius(100, new Circulo(new Punto(20, 200), 28), 2,
				new Proyectil(new Circulo(new Punto(20, 20), 1), 2, RecursosExternos.laser), RecursosExternos.player));*/
		// dariusEnPantalla[2] = new Darius(100, new Circulo(new Punto(20, 350), 5), 3,
		// new Proyectil(new Circulo(new Punto(20, 20), 1),
		// 3,RecursosExternos.laser),RecursosExternos.player);
		// dariusEnPantalla[3] = new Darius(100, new Circulo(new Punto(20, 500), 5), 4,
		// new Proyectil(new Circulo(new Punto(20, 20), 1),
		// 4,RecursosExternos.laser),RecursosExternos.player);
		firerate = new Cronometro();
		cd = new Cronometro();
		enemigoFireRate = new Cronometro();
	}

	public void calcularColisiones() {

		ArrayList<EntidadAbstracta> eliminar = new ArrayList<EntidadAbstracta>();
		ArrayList<EntidadAbstracta> eliminarEntidad = new ArrayList<EntidadAbstracta>();

		for (Darius aliado : dariusEnPantalla) {
			for (Proyectil proyectil : proyectilesEnemigos) {
				if (aliado.chocar(proyectil)) {
					eliminar.add(proyectil);
					System.out.println("me dieron" + aliado.getVida() );
				}

			}
			proyectilesEnemigos.removeAll(eliminar);
			eliminar.clear();
			for (Enemigo enemigo : enemigosEnPantalla) {
				aliado.chocar(enemigo);
			}
			if (aliado.getVida() == 0) {
				eliminarEntidad.add(aliado);

				RecursosExternos.explosion.play();
			}
		}
		dariusEnPantalla.removeAll(eliminarEntidad);
		eliminarEntidad.clear();

		for (Enemigo enemigo : enemigosEnPantalla) {
			for (Proyectil proyectil : proyectilesAliados) {
				if (enemigo.chocar(proyectil)) {
					eliminar.add(proyectil);
					System.out.println("le diste xd" + enemigo.getVida() + " -" + enemigo.estoyMuerto());

				}
			}
			proyectilesAliados.removeAll(eliminar);
			eliminar.clear();
			if (enemigo.getVida() == 0) {
				eliminarEntidad.add(enemigo);
				playExplosion(enemigo.getCuerpo());
				RecursosExternos.explosion.play();
				System.out.println("a la lista xd");
			}

		}
		if (enemigosEnPantalla.removeAll(eliminarEntidad)) {

			System.out.println(enemigosEnPantalla.size());
		}

	}

	public void aniadirEnemigos(int cant, Enemigo enemigo) {
		for (int i = 0; i < cant; i++) {
			bufferEnemigos.add(enemigo.clone());
		}
	}

	public void cleanObjOutOfScreen(int altura, int ancho) {
		ArrayList<EntidadAbstracta> eliminacion = new ArrayList<EntidadAbstracta>();
		for (Proyectil proyectil : proyectilesEnemigos) {

			if (estaElObjetoEnPantalla(proyectil)) {
				eliminacion.add(proyectil);

			}
		}
		proyectilesEnemigos.removeAll(eliminacion);
		eliminacion.clear();
		for (Proyectil proyectil : proyectilesAliados) {

			if (estaElObjetoEnPantalla(proyectil)) {
				eliminacion.add(proyectil);

			}
		}
		proyectilesAliados.removeAll(eliminacion);

		eliminacion.clear();

		for (Enemigo enemigo : enemigosEnPantalla) {

			if (estaElObjetoEnPantalla(enemigo)) {
				eliminacion.add(enemigo);
				System.out.println("se fue nomas");
			}
		}
		enemigosEnPantalla.removeAll(eliminacion);
		eliminacion.clear();

	}

	public boolean estaElObjetoEnPantalla(EntidadAbstracta e) {
		Circulo aux = e.getCirculo();
		double radio = aux.getRadio();
		double x = aux.getX();
		double y = aux.getY();
		if (x - radio > Constantes.ANCHO_PANTALLA || x + radio < -100 || y - radio > Constantes.ALTO_PANTALLA || y + radio < -100)
			return true;
		return false;

	}

	public void ataqueEnemigo() {
		for (Enemigo enemigo : enemigosEnPantalla) {
			proyectilesEnemigos.add(enemigo.disparar());

		}

	}

	public void dibujar(Graphics g) {
		Graphics2D  g2d= (Graphics2D)g;
		for (Darius darius : dariusEnPantalla) {
			darius.dibujar(g);

		}
		for (Proyectil P : proyectilesAliados) {
			P.dibujar(g);

		}
		for (Proyectil P : proyectilesEnemigos) {
			P.dibujar(g);

		}
		for (Enemigo e : enemigosEnPantalla) {
			e.dibujar(g);
		}
		for(int i = 0;i<exp.size();i++) {
			Animacion anim =exp.get(i);
			g2d.drawImage(anim.getCurrentFrame(), (int)anim.getPosicion().getX(),(int) anim.getPosicion().getY(), null);
			
		}
	}

	public void playExplosion(Circulo posicion) {
		
		exp.add(new Animacion(RecursosExternos.exp,50,posicion));
	}
	
	public boolean actualizar() {

		if (!cd.isRunning() && !bufferEnemigos.isEmpty()) {
			enemigosEnPantalla.add(bufferEnemigos.get(0));
			bufferEnemigos.remove(0);

			cd.run(2000);
		}

		for (Enemigo e : enemigosEnPantalla) {
			e.actualizar();

		}
		if (!enemigoFireRate.isRunning()) {

			ataqueEnemigo();
			enemigoFireRate.run(1000);
		}

		if (KeyBoard.LEFT && dariusEnPantalla.get(0).getX() > 0) {
			dariusEnPantalla.get(0).izquierda();
		}
		if (KeyBoard.UP && dariusEnPantalla.get(0).getY() > 0) {
			dariusEnPantalla.get(0).subir();
		}
		if (KeyBoard.DOWN && dariusEnPantalla.get(0).getY() < Constantes.ALTO_PANTALLA - 90) {
			dariusEnPantalla.get(0).bajar();
		}
		if (KeyBoard.RIGHT && dariusEnPantalla.get(0).getX() < Constantes.ANCHO_PANTALLA - 56) {
			dariusEnPantalla.get(0).derecha();
		}
		if (KeyBoard.SHOOT && !firerate.isRunning()) {
			proyectilesAliados.add(dariusEnPantalla.get(0).disparar());
			firerate.run(100);
			RecursosExternos.shoot.play();
		}
		for (Proyectil proyectil : proyectilesAliados) {
			proyectil.actualizar();

		}
		for (Proyectil proyectil : proyectilesEnemigos) {
			proyectil.actualizar();

		}
		for(int i = 0;i<exp.size();i++) {
			Animacion anim =exp.get(i);
			anim.update();
			if(!anim.isRunning()) {
				exp.remove(i);
			}
		}
		cleanObjOutOfScreen(Constantes.ALTO_PANTALLA, Constantes.ANCHO_PANTALLA);
		calcularColisiones();
		firerate.update();
		cd.update();
		enemigoFireRate.update();
		
		boolean hayEnemigos = dariusEnPantalla.size()>0 && !bufferEnemigos.isEmpty();
		boolean hayEnemigos2 = dariusEnPantalla.size()>0 && enemigosEnPantalla.size()>0;
		return hayEnemigos || hayEnemigos2;
	}

}