package Juego.Entidades;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Juego.Graficos.LifeBarGif;
import Juego.Graficos.RecursosExternos;
import Juego.Utils.Circulo;
import Juego.Utils.Punto;

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

	public double getVidaMax() {
		return this.vidaMax;
	}

	public Darius(double vida, Circulo cuerpo, int clave, Proyectil proyectil, BufferedImage textura) {
		super(cuerpo, textura);
		this.proyectil = proyectil;
		this.proyectil.setClave(clave);
		this.vidaMax = vida;
		this.vida = this.vidaMax;
		this.clave = clave;
	}

	public boolean chocar(EntidadAbstracta entidad) {
		if (this.intersectaCon(entidad.cuerpo) && (entidad.getClave() * this.getClave()) < 0) {
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
		return new Proyectil(new Circulo(new Punto(cuerpo.getX(), cuerpo.getY()), 10.0), 1, RecursosExternos.laser);
	}

	public void setInvulnerable(boolean invulnerable) {
		this.invulnerable = invulnerable;
	}

	public void subir() {
		super.cuerpo.mover(new Punto(0, -0.2));
	}

	public void bajar() {
		super.cuerpo.mover(new Punto(0, 0.2));
	}

	public void izquierda() {
		super.cuerpo.mover(new Punto(-0.2, 0));
	}

	public void derecha() {
		super.cuerpo.mover(new Punto(0.2, 0));
	}

	public int getClave() {
		return this.clave;
	}

	public int getX() {
		return (int) (this.cuerpo.getX() - this.cuerpo.getRadio());
	}

	public int getY() {
		return (int) (this.cuerpo.getY() - this.cuerpo.getRadio());
	}

	@Override
	public void actualizar() {

	}

	@Override
	public void dibujar(Graphics g) {
		g.drawImage(LifeBarGif.getFrame(vida,vidaMax), getX()-12, getY()-12,60,20, null);
		g.drawImage(textura, getX(), getY(), null);
	}
}