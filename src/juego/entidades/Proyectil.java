package juego.entidades;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import juego.graficos.RecursosExternos;
import juego.utils.Angulo;
import juego.utils.Circulo;
import juego.utils.Punto;

public class Proyectil extends Entidad implements Cloneable {
	
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

	

	public Proyectil(double ataque, Circulo cuerpo, int clave, Angulo angulo, double velocidad,BufferedImage textura) {
		super(cuerpo, textura);
		this.ataque = ataque;

		this.clave = clave;
		this.angulo = angulo;
		this.velocidad = velocidad;
	}

	public Proyectil(Circulo cuerpo, int clave, BufferedImage textura) {
		super(cuerpo,textura);
		this.ataque = 10;
		this.clave = clave;
		this.angulo = new Angulo(0);
		this.velocidad = 25;
	}

	public Proyectil clone() {
		try {
			return (Proyectil) super.clone();
		} catch (CloneNotSupportedException ex) {
			Circulo clonCuerpo = this.cuerpo.clone();
			Angulo clonAncgulo = this.angulo.clone();
			return new Proyectil(this.ataque, clonCuerpo, this.clave, clonAncgulo, this.velocidad, RecursosExternos.laserRed);
		}
	}
	
	public void chocar(Entidad entidad) {
		if (this.intersectaCon(entidad.cuerpo) && entidad.getClave()!=this.clave && this.getClass() != entidad.getClass()) {
			this.recibirDanio(entidad.ataque);
		}
	}

	@Override
	public void recibirDanio(double danio) {
		this.ataque = 0;
	}

	public void avanzar() {
		super.cuerpo.mover(new Punto(0,0.5));
	}
	public int getX() {
		return (int) (this.cuerpo.getX() - this.cuerpo.getRadio());
	}
	public int getY() {
		return (int) (this.cuerpo.getY() - this.cuerpo.getRadio());
	}
	@Override
	public void actualizar() {
		//super.cuerpo.mover(new Punto(0.5,0));
		super.cuerpo.mover(new Punto(this.velocidad*Math.cos(Math.toRadians(angulo.getValor())),this.velocidad*Math.sin(Math.toRadians(angulo.getValor()))));
		
		// TODO Auto-generated method stub
		
	}
	public BufferedImage getTextura() {
		return textura;
	}

	@Override
	public void dibujar(Graphics g) {
		g.drawImage(getTextura(),getX(),getY(), null);
		
	}

	
}