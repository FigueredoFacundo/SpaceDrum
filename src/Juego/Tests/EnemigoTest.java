package Juego.Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import Juego.Entidades.Darius;
import Juego.Entidades.Enemigo;
import Juego.Entidades.Proyectil;
import Juego.Graficos.RecursosExternos;
import Juego.Utils.Angulo;
import Juego.Utils.Circulo;
import Juego.Utils.Punto;

public class EnemigoTest {

	@Test
	public void ChocarDariusQuitaVida() {
		
		Darius d1 = new Darius(100, new Circulo(new Punto(20, 20), 5), 1,
				new Proyectil(new Circulo(new Punto(20, 20), 1), 1,RecursosExternos.laser),RecursosExternos.player);
		Enemigo e1 = new Enemigo(new Circulo(new Punto(21, 21), 1.5), 100, 25, new Angulo(90),
				new Proyectil(new Circulo(new Punto(20, 20), 1), 1,RecursosExternos.laser),RecursosExternos.player,1);
		
		e1.chocar(d1);
		assertEquals(e1.getVidaMax()-d1.getAtaque(), e1.getVida(), 0);
		
	}

	@Test
	public void ChocarProyectilDariusQuitaVida() {
		
		Darius d1 = new Darius(100, new Circulo(new Punto(20, 20), 5), 1,
				new Proyectil(new Circulo(new Punto(26, 26), 1), 1,RecursosExternos.laser),RecursosExternos.player);
		Enemigo e1 = new Enemigo(new Circulo(new Punto(26, 26), 1.5), 100, 25, new Angulo(90),
				new Proyectil(new Circulo(new Punto(20, 20), 1), 1,RecursosExternos.laser),RecursosExternos.player,1);
		
		e1.chocar(d1.getProyectil());
		assertEquals(e1.getVidaMax()-d1.getProyectil().getAtaque(), e1.getVida(), 0);
		
	}
	
	@Test
	public void ChocarEnemigoNoDania() {
		
		Enemigo e1 = new Enemigo(new Circulo(new Punto(26, 26), 1.5), 100, 25, new Angulo(90),
				new Proyectil(new Circulo(new Punto(20, 20), 1), 1,RecursosExternos.laser),RecursosExternos.player,1);
		Enemigo e2 = new Enemigo(new Circulo(new Punto(26, 26), 1.5), 100, 25, new Angulo(90),
				new Proyectil(new Circulo(new Punto(20, 20), 1), 1,RecursosExternos.laser),RecursosExternos.player,1);
		
		
		e1.chocar(e2);
		assertEquals(e1.getVidaMax(), e1.getVida(), 0);
		assertEquals(e2.getVidaMax(), e2.getVida(), 0);
		
	}
	
	@Test
	public void ChocarProyectilEnemigoNoDania() {
		
		Enemigo e1 = new Enemigo(new Circulo(new Punto(26, 26), 1.5), 100, 25, new Angulo(90),
				new Proyectil(new Circulo(new Punto(20, 20), 1), 1,RecursosExternos.laser),RecursosExternos.player,1);
		Enemigo e2 = new Enemigo(new Circulo(new Punto(26, 26), 1.5), 100, 25, new Angulo(90),
				new Proyectil(new Circulo(new Punto(20, 20), 1), 1,RecursosExternos.laser),RecursosExternos.player,1);
		
		e1.chocar(e2.getProyectil());
		assertEquals(e1.getVidaMax(), e1.getVida(), 0);
		
		
	}
	
	@Test
	public void EnemigoDispara() {
		
		Enemigo e1 = new Enemigo(new Circulo(new Punto(26, 26), 1.5), 100, 25, new Angulo(90),
				new Proyectil(new Circulo(new Punto(20, 20), 1), 1,RecursosExternos.laser),RecursosExternos.player,1);
		
		assertNotEquals(e1.getProyectil(), e1.disparar());
		
		
	}
	

}
