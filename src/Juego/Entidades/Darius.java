package Juego.Entidades;

import Juego.Utils.Circulo;
import Juego.Utils.Punto;

public class Darius extends EntidadAbstracta {
	private double vida;
	private double ataque = 0;
	private String color;

	private boolean invulnerable;

	public Darius(double vida, Circulo cuerpo, String color) {
		super(cuerpo);
		this.vida = vida;
		this.color = color;
	}

	@Override
	public void chocar(EntidadAbstracta entidad) {
		if (entidad.intersectaCon(super.cuerpo) && entidad.debilAnte(this)) {
			entidad.recibirDaño(this.ataque);
		}
	}

	@Override
	public boolean debilAnte(EntidadAbstracta entidad) {
		return entidad instanceof Enemigo;
	}

	@Override
	public void recibirDaño(double daño) {
		if (!this.invulnerable && this.vida >= 0) {
			this.vida -= daño;
		}
		if (vida <= 0) {
			this.vida = 0;
		}
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

	public String getColor() {
		return color;
	}
}
