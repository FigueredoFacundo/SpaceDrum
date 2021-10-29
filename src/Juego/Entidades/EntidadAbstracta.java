package Juego.Entidades;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Juego.Utils.Circulo;

public abstract class EntidadAbstracta{
	
	protected Circulo cuerpo;
	protected double ataque = 0;
	protected int clave = 0;
	protected BufferedImage textura; 
	
	public int getClave()
	{
		return clave;
	}
	
	public void setClave(int clave)
	{
		this.clave = clave;
	}
	
	public Circulo getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(Circulo cuerpo) {
		this.cuerpo = cuerpo;
	}

	public double getAtaque() {
		return ataque;
	}

	public void setAtaque(double ataque) {
		this.ataque = ataque;
	}

	
	public EntidadAbstracta(Circulo cuerpo, BufferedImage textura) {
		super();
		this.cuerpo = cuerpo;
		this.textura = textura;
	}
	
	public boolean intersectaCon(Circulo otroCuerpo) {
		return this.cuerpo.intersectaCon(otroCuerpo);
	}
	public abstract void recibirDanio(double danio);
	
	public Circulo getCirculo() {
		return this.cuerpo;
	}
	
	
	public abstract void actualizar();
	public abstract void dibujar(Graphics g);
	
	
	
	
}