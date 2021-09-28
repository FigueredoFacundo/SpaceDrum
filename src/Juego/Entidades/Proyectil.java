package Juego.Entidades;

import Juego.Utils.Angulo;
import Juego.Utils.Circulo;
import Juego.Utils.Punto;

public class Proyectil extends EntidadAbstracta implements Cloneable {
	private double ataque;
	private boolean esDebil;
	private EntidadAbstracta propietario;
	private Angulo angulo;
	// Caracterisica magia que nos va a servir mas adelante
	private double velocidad;

	public Proyectil(double ataque, Circulo cuerpo, boolean esDebil, EntidadAbstracta propietario, Angulo angulo,
			double velocidad) {
		super(cuerpo);
		this.ataque = ataque;
		this.esDebil = esDebil;
		this.propietario = propietario;
		this.angulo = angulo;
		this.velocidad = velocidad;
	}

	public Proyectil clone() {
		try {
			return (Proyectil) super.clone();
		} catch (CloneNotSupportedException ex) {
			Circulo clonCuerpo = this.cuerpo.clone();
			Angulo clonAncgulo = this.angulo.clone();
			return new Proyectil(this.ataque, clonCuerpo, this.esDebil, this.propietario, clonAncgulo, this.velocidad);
		}
	}

	@Override
	public void chocar(EntidadAbstracta Entidad) {
		if (Entidad.intersectaCon(super.cuerpo) && (Entidad.debilAnte(this.propietario) || Entidad.debilAnte(this))) {
			Entidad.recibirDaño(ataque);
		}
		this.ataque = 0;
	}

	@Override
	public void recibirDaño(double daño) {
		this.ataque = 0;
	}

	@Override
	public boolean debilAnte(EntidadAbstracta entidad) {
		if (!(entidad instanceof Proyectil)) {
			return false;
		}
		Proyectil proyectil = (Proyectil) entidad;

		return this.esDebil && this.propietario instanceof Enemigo && proyectil.propietario instanceof Darius;
	}

	public void avanzar() {
		super.cuerpo.mover(new Punto(Math.cos(angulo.getValor()), Math.sin(angulo.getValor())));
	}
}
