package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Utils.Circulo;
import Utils.Punto;

public class CirculoTest {
	Circulo circulo;

	
	
	
	@Test
	public void C1GrandeC2AdentroSiIntersectan() {
		Circulo c1 = new Circulo(new Punto(0, 0), 3);
		Circulo c2 = new Circulo(new Punto(2.5, 2.5), 1);
		assertTrue(c1.intersectaCon(c2));
	}
	
	@Test
	public void C1GrandeC2AfueraNoIntersectan() {
		Circulo c1 = new Circulo(new Punto(0, 0), 2);
		Circulo c2 = new Circulo(new Punto(3, 3), 0.5);
		assertFalse(c1.intersectaCon(c2));
	}
	
	@Test
	public void C1GrandeC2AfueraSiIntersectan() {
		Circulo c1 = new Circulo(new Punto(0, 0), 2.5);
		Circulo c2 = new Circulo(new Punto(3, 3), 2);
		assertTrue(c1.intersectaCon(c2));
	}

	@Test
	public void C1ChicoC1AdentroNoIntersectan() {
		Circulo c1 = new Circulo(new Punto(1, 1), 1);
		Circulo c2 = new Circulo(new Punto(0, 0), 3);
		assertFalse(c1.intersectaCon(c2));
	}
	
	@Test
	public void C1ChicoC1AdentroSiIntersectan() {
		Circulo c1 = new Circulo(new Punto(2.5, 2.5), 1);
		Circulo c2 = new Circulo(new Punto(0, 0), 3);
		assertTrue(c1.intersectaCon(c2));
	}
	
	@Test
	public void C1ChicoC1AfueraNoIntersectan() {
		Circulo c1 = new Circulo(new Punto(3, 3), 0.5);
		Circulo c2 = new Circulo(new Punto(0, 0), 2);
		assertFalse(c1.intersectaCon(c2));
	}
	
	@Test
	public void C1ChicoC1AfueraSiIntersectan() {
		Circulo c1 = new Circulo(new Punto(3, 3), 2);
		Circulo c2 = new Circulo(new Punto(0, 0), 2.5);
		assertTrue(c1.intersectaCon(c2));
	}


}
