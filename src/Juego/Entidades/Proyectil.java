package Entidades;

import Utils.Angulo;
import Utils.Circulo;
import Utils.Punto;

public class Proyectil extends EntidadAbstracta implements Cloneable {
	
	private Angulo angulo;
	// Caracterisica magia que nos va a servir mas adelante
	private double velocidad;
	
	
	public double getAtaque() {
		return ataque;
	}

	public void setAtaque(double ataque) {
		this.ataque = ataque;
	}

	
	public Angulo getAngulo() {
		return angulo;
	}

	public void setAngulo(Angulo angulo) {
		this.angulo = angulo;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	

	public Proyectil(double ataque, Circulo cuerpo, int clave, Angulo angulo, double velocidad) {
		super(cuerpo);
		this.ataque = ataque;

		this.clave = clave;
		this.angulo = angulo;
		this.velocidad = velocidad;
	}

	public Proyectil(Circulo cuerpo, int clave) {
		super(cuerpo);
		this.ataque = 10;
		this.clave = clave;
		this.angulo = new Angulo(0);
		this.velocidad = 1;
	}

	public Proyectil clone() {
		try {
			return (Proyectil) super.clone();
		} catch (CloneNotSupportedException ex) {
			Circulo clonCuerpo = this.cuerpo.clone();
			Angulo clonAncgulo = this.angulo.clone();
			return new Proyectil(this.ataque, clonCuerpo, this.clave, clonAncgulo, this.velocidad);
		}
	}
	
	public void chocar(EntidadAbstracta entidad) {
		if (this.intersectaCon(entidad.cuerpo) && entidad.getClave()!=this.clave && this.getClass() != entidad.getClass()) {
			this.recibirDanio(entidad.ataque);
		}
	}

	@Override
	public void recibirDanio(double danio) {
		this.ataque = 0;
	}

	public void avanzar() {
		super.cuerpo.mover(new Punto(this.velocidad*Math.cos(angulo.getValor()),this.velocidad*Math.sin(angulo.getValor())));
	}

	
}