package Juego.Entidades;

import java.util.ArrayList;

import Juego.Utils.Angulo;
import Juego.Utils.Circulo;
import Juego.Utils.Punto;

public class Enemigo extends EntidadAbstracta {
	private double vida;
	private double ataque = 0;
	private Angulo angulo;
	private Proyectil[] proyectiles;

	public Enemigo(Circulo cuerpo, double vida, double ataque, Angulo angulo, Proyectil[] proyectiles) {
		super(cuerpo);
		this.vida = vida;
		this.proyectiles = proyectiles;
		this.ataque = ataque;
		this.angulo = angulo;
	}

	@Override
	public void chocar(EntidadAbstracta entidad) {
		if (entidad.intersectaCon(this.cuerpo) && entidad.debilAnte(this)) {
			entidad.recibirDaño(this.ataque);
		}
	}

	@Override
	public boolean debilAnte(EntidadAbstracta entidad) {
		return entidad instanceof Darius;
	}

	@Override
	public void recibirDaño(double daño) {
		if (this.vida >= 0) {
			this.vida -= daño;
		}
		if (vida <= 0) {
			this.vida = 0;
		}
	}

	public Proyectil[] disparar() {
		ArrayList<Proyectil> clonesProyectiles = new ArrayList<Proyectil >();
		for (Proyectil proyectil : this.proyectiles) {
			clonesProyectiles.add(proyectil.clone(this));
		}
		return (Proyectil[]) clonesProyectiles.toArray();
	}
	
	public void avanzar() {
		super.cuerpo.mover(new Punto(Math.cos(angulo.getValor()), Math.sin(angulo.getValor())));
	}
}
