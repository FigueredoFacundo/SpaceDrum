package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Utils.Punto;

public class PuntoTest {

	@Test
	public void MovimientoNulo() {
		
		Punto p1 = new Punto (1, 1);
		
		p1.mover(new Punto(0, 0));
		assertEquals(1, p1.getX(), 0);
		assertEquals(1, p1.getY(), 0);	
		
	}
	
	@Test
	public void MovimientoAdelante() {
		
		Punto p1 = new Punto (1, 1);
		
		p1.mover(new Punto(1, 0));
		assertEquals(2, p1.getX(), 0);
		assertEquals(1, p1.getY(), 0);	
		
	}
	
	@Test
	public void MovimientoAtras() {
		
		Punto p1 = new Punto (1, 1);
		
		p1.mover(new Punto(-1, 0));
		assertEquals(0, p1.getX(), 0);
		assertEquals(1, p1.getY(), 0);	
		
	}
	
	@Test
	public void MovimientoArriba() {
		
		Punto p1 = new Punto (1, 1);
		
		p1.mover(new Punto(0, 1));
		assertEquals(1, p1.getX(), 0);
		assertEquals(2, p1.getY(), 0);	
		
	}
	
	@Test
	public void MovimientoAbajo() {
		
		Punto p1 = new Punto (1, 1);
		
		p1.mover(new Punto(0, -1));
		assertEquals(1, p1.getX(), 0);
		assertEquals(0, p1.getY(), 0);	
		
	}

}
