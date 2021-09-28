package Juego.Utils;

public class Punto {
	private double x, y;

	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double obtenerDistancia(Punto p2) {
		return Math.sqrt(Math.pow(this.getX() - p2.getX(), 2) + Math.pow(this.getY() - p2.getY(), 2));
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void mover( Punto desplazamiento ) {
		this.x += desplazamiento.getX();
		this.y += desplazamiento.getY();
	}
}