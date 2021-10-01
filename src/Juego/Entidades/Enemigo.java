package Entidades;

import Utils.Angulo;
import Utils.Circulo;
import Utils.Punto;

public class Enemigo extends EntidadAbstracta implements Cloneable {
	

	public double getVidaMax() {
		return vidaMax;
	}

	public void setVidaMax(double vidaMax) {
		this.vidaMax = vidaMax;
	}

	public Proyectil getProyectiles() {
		return proyectiles;
	}

	public void setProyectiles(Proyectil proyectiles) {
		this.proyectiles = proyectiles;
	}

	private double vida;
	private double vidaMax;
	private Angulo angulo;
	private Proyectil proyectiles;
	
	public int getClave() {
		return clave;
	}

	public Proyectil getProyectil()
	{
		return this.proyectiles;
	}
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

	public Angulo getAngulo() {
		return angulo;
	}

	public void setAngulo(Angulo angulo) {
		this.angulo = angulo;
	}

	

	

	public Enemigo(Circulo cuerpo, double vida, double ataque, Angulo angulo, Proyectil proyectiles) {
		super(cuerpo);
		this.vidaMax= vida;
		this.vida = vidaMax;
		
		this.clave = 0;
		this.proyectiles = proyectiles;
		this.proyectiles.setClave(this.clave);
		this.ataque = ataque;
		this.angulo = angulo;
	}

	public void chocar(EntidadAbstracta entidad) {
		if (this.intersectaCon(entidad.cuerpo) && entidad.getClave()!=this.clave) {
			this.recibirDanio(entidad.ataque);
		}
	}

	@Override
	public void recibirDanio(double danio) {
		if (this.vida >= 0) {
			this.vida -= danio;
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