package Juego.Utils;

public class Circulo implements Cloneable{
	private Punto centro;
	private double radio;
	
	public Circulo(Punto centro, double radio) {
		this.centro = centro;
		this.radio = radio;
	}
	
	public Circulo clone() {
		try {
			return (Circulo) super.clone();
		} catch (CloneNotSupportedException ex) {
			Punto clonCentro = this.centro.clone();
			return new Circulo(clonCentro, this.radio);
		}
	}
	
	public boolean intersectaCon(Circulo c2) { 
	    double d = this.centro.obtenerDistancia(c2.centro);
	  //no intersectan, no estan juntos
	    if (d > this.radio + c2.radio) {	
	        return false;
	    }
	  //uno dentro de otro pero sin tocarse, para el juego si intersectan.
	  /*  if (d < Math.abs(this.radio-c2.radio)) {	
	        return false;
	    }*/
	  //intersectan en uno o más puntos
	    return true; 
	}
	
	public void mover( Punto desplazamiento ) {
		this.centro.mover( desplazamiento );
	}
	public double getRadio() {
		return this.radio;
	}
	public double getX() {
		return centro.getX();
	}
	public double getY() {
		return centro.getY();
	}
}