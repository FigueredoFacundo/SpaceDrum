package Juego.Entidades;

import Juego.Utils.Circulo;

public abstract class EntidadAbstracta{
	protected Circulo cuerpo;
	
	public EntidadAbstracta(Circulo cuerpo) {
		super();
		this.cuerpo = cuerpo;
	}
	
	public boolean intersectaCon(Circulo otroCuerpo) {
		return this.cuerpo.intersectaCon(otroCuerpo);
	}
	public abstract void recibirDaño(double daño);
	public abstract boolean debilAnte(EntidadAbstracta entidad);
	public abstract void chocar(EntidadAbstracta entidad);
}
