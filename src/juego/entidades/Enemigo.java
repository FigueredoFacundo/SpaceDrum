package juego.entidades;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import juego.graficos.RecursosExternos;
import juego.utils.*;

public class Enemigo extends Entidad implements Cloneable {

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
	private double velocidad;

	public int getClave() {
		return clave;
	}

	public Proyectil getProyectil() {
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

	public Enemigo(Circulo cuerpo, double vida, double ataque, Angulo angulo, Proyectil proyectiles,
			BufferedImage textura, double velocidad) {
		super(cuerpo, textura);
		this.vidaMax = vida;
		this.vida = vidaMax;

		this.clave = -1;
		this.proyectiles = proyectiles;
		this.proyectiles.setClave(this.clave);
		this.ataque = ataque;
		this.angulo = angulo;
		this.velocidad = velocidad;
	}

	public boolean chocar(Entidad entidad) {
		if (this.intersectaCon(entidad.cuerpo) && entidad.getClave() != this.clave) {
			this.recibirDanio(entidad.ataque);
			return true;
		}
		return false;
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
		return new Proyectil(10,new Circulo(new Punto(cuerpo.getX(),cuerpo.getY()),10.0),-1,new Angulo(180),10,RecursosExternos.laserRed);
	}

	public void avanzar() {
		super.cuerpo.mover(new Punto(this.velocidad*Math.cos(Math.toRadians(angulo.getValor())),this.velocidad*Math.sin(Math.toRadians(angulo.getValor()))));
		
	}

	public Enemigo clone() {
		Circulo cloncirculo = this.cuerpo.clone();
		Angulo clonangulo = this.angulo.clone();
		Proyectil clonproyectil = this.proyectiles.clone();
		return new Enemigo(cloncirculo, this.vida, this.ataque, clonangulo, clonproyectil,textura, velocidad);
	}

	public int getX() {
		return (int) (this.cuerpo.getX() - this.cuerpo.getRadio());
	}

	public int getY() {
		return (int) (this.cuerpo.getY() - this.cuerpo.getRadio());
	}

	@Override
	public void actualizar() {
		avanzar();

	}

	@Override
	public void dibujar(Graphics g) {
		g.drawImage(textura, getX(), getY(), null);

	}

}