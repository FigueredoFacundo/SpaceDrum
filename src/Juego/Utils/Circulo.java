package Juego.Utils;

public class Circulo {
	private Punto centro;
	private double radio;
	
	public Circulo(Punto centro, double radio) {
		this.centro = centro;
		this.radio = radio;
	}
	
	public boolean intersectaCon(Circulo c2) { 
	    double d = this.centro.obtenerDistancia(c2.centro);
	  //no intersectan, no estan juntos
	    if (d > this.radio + c2.radio) {	
	        return false;
	    }
	  //uno dentro de otro pero sin tocarse, no intersecta
	    if (d < Math.abs(this.radio-c2.radio)) {	
	        return false;
	    }
	  //intersectan en uno o más puntos
	    return true; 
	}
	
	public void mover( Punto desplazamiento ) {
		this.centro.mover( desplazamiento );
	}
}