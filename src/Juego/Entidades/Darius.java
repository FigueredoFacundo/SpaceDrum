package Juego.Entidades;

import Juego.Utils.Circulo;
import Juego.Utils.Punto;

public class Darius extends EntidadAbstracta {
	private double vida;
	private double ataque = 0;
	private int clave;
	private Proyectil proyectil;

	private boolean invulnerable;

	public Darius(double vida, Circulo cuerpo, int clave, Proyectil proyectil) {
		super(cuerpo);
		this.proyectil = proyectil;
		this.vida = vida;
		this.clave = clave;
	}

	public void chocar(EntidadAbstracta entidad) {
		if (entidad.intersectaCon(super.cuerpo)) {
			this.recibirDa�o(this.ataque);
		}
	}

	@Override
	public void recibirDa�o(double da�o) {
		if (!this.invulnerable && this.vida >= 0) {
			this.vida -= da�o;
		}
		if (vida <= 0) {
			this.vida = 0;
		}
	}

	public Proyectil disparar() {
		return this.proyectil.clone();
	}

	public void setInvulnerable(boolean invulnerable) {
		this.invulnerable = invulnerable;
	}

	public void subir() {
		super.cuerpo.mover(new Punto(1, 0));
	}

	public void bajar() {
		super.cuerpo.mover(new Punto(-1, 0));
	}

	public void izqueirda() {
		super.cuerpo.mover(new Punto(0, -1));
	}

	public void derecha() {
		super.cuerpo.mover(new Punto(0, 1));
	}

	public int getClave() {
		return this.clave;
	}
}
