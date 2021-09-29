package Juego.Entidades;

import Juego.Utils.Angulo;
import Juego.Utils.Circulo;
import Juego.Utils.Punto;

public class Proyectil extends EntidadAbstracta implements Cloneable {
	private double ataque;

	private int clavePropietario;
	private Angulo angulo;
	// Caracterisica magia que nos va a servir mas adelante
	private double velocidad;

	public Proyectil(double ataque, Circulo cuerpo, int clavePropietario, Angulo angulo, double velocidad) {
		super(cuerpo);
		this.ataque = ataque;

		this.clavePropietario = clavePropietario;
		this.angulo = angulo;
		this.velocidad = velocidad;
	}

	public Proyectil(Circulo cuerpo, int clave) {
		super(cuerpo);
		this.ataque = 10;
		this.clavePropietario = clave;
		this.angulo = new Angulo(0);
		this.velocidad = 1;
	}

	public Proyectil clone() {
		try {
			return (Proyectil) super.clone();
		} catch (CloneNotSupportedException ex) {
			Circulo clonCuerpo = this.cuerpo.clone();
			Angulo clonAncgulo = this.angulo.clone();
			return new Proyectil(this.ataque, clonCuerpo, this.clavePropietario, clonAncgulo, this.velocidad);
		}
	}

	@Override
	public void recibirDaño(double daño) {
		this.ataque = 0;
	}

	public void avanzar() {
		super.cuerpo.mover(new Punto(Math.cos(angulo.getValor()), Math.sin(angulo.getValor())));
	}

	public int getClave() {
		return this.clavePropietario;
	}
}
