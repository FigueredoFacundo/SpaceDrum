package juego.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import juego.graficos.RecursosExternos;
import juego.utils.Angulo;
import juego.utils.Circulo;
import juego.utils.Punto;
import juego.entidades.Darius;
import juego.entidades.Enemigo;
import juego.entidades.Proyectil;

public class DariusTest {

	
	@Test
	public void ChocarEnemigoQuitaVida() {
		
		Darius d1 = new Darius(100, new Circulo(new Punto(20, 20), 5), 1,
				new Proyectil(new Circulo(new Punto(20, 20), 1), 1,RecursosExternos.laser),RecursosExternos.player);
		Enemigo e1 = new Enemigo(new Circulo(new Punto(21, 21), 1.5), 100, 25, new Angulo(90),
				new Proyectil(new Circulo(new Punto(20, 20), 1), 1,RecursosExternos.laser),RecursosExternos.player,1);
		
		d1.chocar(e1);
		assertEquals(d1.getVidaMax()-e1.getAtaque(), d1.getVida(), 0);
		
	}

	@Test
	public void ChocarProyectilEnemigoQuitaVida() {
		
		Darius d1 = new Darius(100, new Circulo(new Punto(20, 20), 5), 1,
				new Proyectil(new Circulo(new Punto(20, 20), 1), 1,RecursosExternos.laser),RecursosExternos.player);
		Enemigo e1 = new Enemigo(new Circulo(new Punto(21, 21), 1.5), 100, 25, new Angulo(90),
				new Proyectil(new Circulo(new Punto(20, 20), 1), 1,RecursosExternos.laser),RecursosExternos.player,1);
		
		d1.chocar(e1.getProyectil());
		assertEquals(d1.getVidaMax()-e1.getProyectil().getAtaque(), d1.getVida(), 0);
		
	}
	
	@Test
	public void ChocarDariusNoDania() {
		
		Darius d1 = new Darius(100, new Circulo(new Punto(20, 20), 5), 1,
				new Proyectil(new Circulo(new Punto(20, 20), 1), 1,RecursosExternos.laser),RecursosExternos.player);
		Darius d2 = new Darius(100, new Circulo(new Punto(20, 20), 5), 1,
				new Proyectil(new Circulo(new Punto(20, 20), 1), 1,RecursosExternos.laser),RecursosExternos.player);
		
		d1.chocar(d2);
		assertEquals(d1.getVidaMax(), d1.getVida(), 0);
		assertEquals(d2.getVidaMax(), d2.getVida(), 0);
		
	}
	
	@Test
	public void ChocarProyectilDariusNoDania() {
		
		Darius d1 = new Darius(100, new Circulo(new Punto(20, 20), 5), 1,
				new Proyectil(new Circulo(new Punto(20, 20), 1), 1,RecursosExternos.laser),RecursosExternos.player);
		Darius d2 = new Darius(100, new Circulo(new Punto(20, 20), 5), 1,
				new Proyectil(new Circulo(new Punto(20, 20), 1), 1,RecursosExternos.laser),RecursosExternos.player);
		
		d1.chocar(d2.getProyectil());
		assertEquals(d1.getVidaMax(), d1.getVida(), 0);
		
		
	}
	
	@Test
	public void DariusDispara() {
		
		Darius d1 = new Darius(100, new Circulo(new Punto(20, 20), 5), 1,
				new Proyectil(new Circulo(new Punto(20, 20), 1), 1,RecursosExternos.laser),RecursosExternos.player);
		assertNotEquals(d1.getProyectil(), d1.disparar());
		
		
	}
	
	

}
