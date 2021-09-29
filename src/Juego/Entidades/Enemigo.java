package Juego.Entidades;

import Juego.Utils.Angulo;
import Juego.Utils.Circulo;
import Juego.Utils.Punto;

public class Enemigo extends EntidadAbstracta implements Cloneable {
	private double vida;
	private double ataque = 0;
	private Angulo angulo;
	private Proyectil proyectiles;

	public Enemigo(Circulo cuerpo, double vida, double ataque, Angulo angulo, Proyectil proyectiles) {
		super(cuerpo);
		this.vida = vida;
		this.proyectiles = proyectiles;
		this.ataque = ataque;
		this.angulo = angulo;
	}

	public void chocar(EntidadAbstracta entidad) {
		if (entidad.intersectaCon(super.cuerpo)) {
			entidad.recibirDa�o(this.ataque);
		}
	}

	@Override
	public void recibirDa�o(double da�o) {
		if (this.vida >= 0) {
			this.vida -= da�o;
		}
		if (vida <= 0) {
			this.vida = 0;
		}
	}

	public boolean estoyMuerto() {
		return this.vida == 0;
	}

	public Proyectil disparar() {
		return this.proyectiles.clone();
	}

	public void avanzar() {
		super.cuerpo.mover(new Punto(Math.cos(angulo.getValor()), Math.sin(angulo.getValor())));
	}

	public Enemigo clone() {
		Circulo cloncirculo = this.cuerpo.clone();
		Angulo clonangulo = this.angulo.clone();
		Proyectil clonproyectil = this.proyectiles.clone();
		return new Enemigo(cloncirculo, this.vida, this.ataque, clonangulo, clonproyectil);
	}

}
