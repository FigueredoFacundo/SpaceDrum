package logica;

import java.util.ArrayList;

import Juego.Entidades.*;
import Juego.Utils.*;

public class Mapa {
	ArrayList<Enemigo> enemigosEnPantalla = new ArrayList<Enemigo>();
	Darius dariusEnPantalla[] = new Darius[4];
	ArrayList<Proyectil> proyectilesEnemigos = new ArrayList<Proyectil>();
	ArrayList<Proyectil> proyectilesAliados = new ArrayList<Proyectil>();

	public Mapa() {
		dariusEnPantalla[0] = new Darius(100, new Circulo(new Punto(20, 20), 5), 1,
				new Proyectil(new Circulo(new Punto(20, 20), 1), 1));
		dariusEnPantalla[1] = new Darius(100, new Circulo(new Punto(40, 20), 5), 2,
				new Proyectil(new Circulo(new Punto(40, 20), 1), 2));
		dariusEnPantalla[2] = new Darius(100, new Circulo(new Punto(60, 20), 5), 3,
				new Proyectil(new Circulo(new Punto(60, 20), 1), 3));
		dariusEnPantalla[3] = new Darius(100, new Circulo(new Punto(80, 20), 5), 4,
				new Proyectil(new Circulo(new Punto(80, 20), 1), 4));
	}

	public int[] calcularColisiones() {
		int[] bajasAliadas = { 0, 0, 0, 0 };
		for (Darius aliado : dariusEnPantalla) {
			for (Proyectil proyectil : proyectilesEnemigos) {
				aliado.chocar(proyectil);
			}
			for (Enemigo enemigo : enemigosEnPantalla) {
				aliado.chocar(enemigo);
			}
		}
		for (Enemigo enemigo : enemigosEnPantalla) {
			for (Proyectil proyectil : proyectilesAliados) {
				enemigo.chocar(proyectil);
				if (enemigo.estoyMuerto()) {
					bajasAliadas[proyectil.getClave() - 1]++;
					enemigosEnPantalla.remove(enemigo);
				}
			}
		}
		return bajasAliadas;
	}

	public void añadirEnemigos(int cant, Enemigo enemigo) {
		for (int i = 0; i < cant; i++) {
			enemigosEnPantalla.add(enemigo.clone());
		}
	}

	public void cleanObjOutOfScreen(int altura, int ancho) {
		for (Proyectil proyectil : proyectilesEnemigos) {

			if (estaElObjetoEnPantalla(proyectil)) {
				proyectilesEnemigos.remove(proyectil);
			}
		}
		for (Proyectil proyectil : proyectilesAliados) {

			if (estaElObjetoEnPantalla(proyectil)) {
				proyectilesEnemigos.remove(proyectil);
			}
		}
		for (Enemigo enemigo : enemigosEnPantalla) {

			if (estaElObjetoEnPantalla(enemigo)) {
				enemigosEnPantalla.remove(enemigo);
			}
		}

	}

	public boolean estaElObjetoEnPantalla(EntidadAbstracta e) {
		Circulo aux = e.getCirculo();
		double radio = aux.getRadio();
		double x = aux.getX();
		double y = aux.getY();
		if (x - radio > 800 || x + radio < 0 || y - radio > 600 || y + radio < 0)
			return true;
		return false;
		

	}
	public void ataqueEnemigo() {
		for(Enemigo enemigo:enemigosEnPantalla) {
			proyectilesEnemigos.add(enemigo.disparar());
		}
	}
	

}
