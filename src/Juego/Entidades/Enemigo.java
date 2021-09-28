package Juego.Entidades;

import Juego.Utils.Angulo;
import Juego.Utils.Circulo;
import Juego.Utils.Punto;

public class Enemigo extends EntidadAbstracta {
	private double vida;
	private double ataque = 0;
	private Angulo angulo;

	public Enemigo(Circulo cuerpo, double vida, double ataque, Angulo angulo) {
		super(cuerpo);
		this.vida = vida;
		this.ataque = ataque;
		this.angulo = angulo;
	}

	@Override
	public void chocar(EntidadAbstracta entidad) {
		if (entidad.intersectaCon(this.cuerpo) && entidad.debilAnte(this)) {
			entidad.recibirDa�o(this.ataque);
		}
	}

	@Override
	public boolean debilAnte(EntidadAbstracta entidad) {
		return entidad instanceof Darius;
	}

	@Override
	public void recibirDa�o(double da�o) {
		if (this.vida >= 0) {
			this.vida -= da�o;
		}
		if (vida <= 0) {
			this.vida = 0;
		}
	}

	public void avanzar() {
		super.cuerpo.mover(new Punto(Math.cos(angulo.getValor()), Math.sin(angulo.getValor())));
	}
}
