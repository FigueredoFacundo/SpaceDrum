package juego.utils;

public class Angulo implements Cloneable{

	private double valor;

	public Angulo(double valor) {
		super();
		this.valor = valor;
	}

	public Angulo clone() {
		try {
			return (Angulo) super.clone();
		} catch (CloneNotSupportedException ex) {
			return new Angulo(this.valor);
		}
	}
	
	public double getValor() {
		return valor;
	}

	public void up(double valor) {
		this.valor += valor;
		this.valor %= 360;
	}

	public void down(double valor) {
		this.valor -= valor;
		this.valor %= 360;
	}
}