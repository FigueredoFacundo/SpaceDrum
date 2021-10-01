package Entidades;

import Utils.Circulo;
import Utils.Punto;

public class Darius extends EntidadAbstracta {
	
	
	private double vidaMax;
	private double vida;
	private Proyectil proyectil;
	private boolean invulnerable;
	
	
	public double getVida() {
		return vida;
	}

	public void setVida(double vida) {
		this.vida = vida;
	}

	public double getAtaque() {
		return ataque;
	}

	public void setAtaque(double ataque) {
		this.ataque = ataque;
	}

	public Proyectil getProyectil() {
		return proyectil;
	}

	public void setProyectil(Proyectil proyectil) {
		this.proyectil = proyectil;
	}

	public boolean isInvulnerable() {
		return invulnerable;
	}

	public void setVidaMax(double vidaMax) {
		this.vidaMax = vidaMax;
	}

	public double getVidaMax()
	{
		return this.vidaMax;
	}
	
	public Darius(double vida, Circulo cuerpo, int clave, Proyectil proyectil) {
		super(cuerpo);
		this.proyectil = proyectil;
		this.proyectil.setClave(clave);
		this.vidaMax = vida;
		this.vida = this.vidaMax;
		this.clave = clave;
	}
	
	

	public boolean chocar(EntidadAbstracta entidad) {
		if (this.intersectaCon(entidad.cuerpo) && entidad.getClave() == 0) {
			this.recibirDanio(entidad.getAtaque());
			return true;
		}
		return false;
	}

	@Override
	public void recibirDanio(double danio) {
		if (!this.invulnerable && this.vida >= 0) {
			this.vida -= danio;
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