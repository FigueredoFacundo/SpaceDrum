package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Entidades.Darius;
import Entidades.Enemigo;
import Entidades.Proyectil;
import Utils.Angulo;
import Utils.Circulo;
import Utils.Punto;

public class ProyectilTest {

	@Test
	public void MovimientoEnAngulo45() {
		
		Proyectil p1 = new Proyectil(10, new Circulo(new Punto(0, 0), 1), 1, new Angulo(45), 1);
		
		p1.avanzar();
		assertEquals(Math.cos(45), p1.getCirculo().getX(), 0);
		assertEquals(Math.sin(45), p1.getCirculo().getY(), 0);
		
	}
	
	@Test
	public void MovimientoEnAngulo135() {
		
		Proyectil p1 = new Proyectil(10, new Circulo(new Punto(0, 0), 1), 1, new Angulo(135), 1);
		
		p1.avanzar();
		assertEquals(Math.cos(135), p1.getCirculo().getX(), 0);
		assertEquals(Math.sin(135), p1.getCirculo().getY(), 0);
		
	}
	
	@Test
	public void MovimientoEnAngulo225() {
		
		Proyectil p1 = new Proyectil(10, new Circulo(new Punto(0, 0), 1), 1, new Angulo(225), 1);
		
		p1.avanzar();
		assertEquals(Math.cos(225), p1.getCirculo().getX(), 0);
		assertEquals(Math.sin(225), p1.getCirculo().getY(), 0);
		
	}
	
	@Test
	public void MovimientoEnAngulo315() {
		
		Proyectil p1 = new Proyectil(10, new Circulo(new Punto(0, 0), 1), 1, new Angulo(315), 1);
		
		p1.avanzar();
		assertEquals(Math.cos(315), p1.getCirculo().getX(), 0);
		assertEquals(Math.sin(315), p1.getCirculo().getY(), 0);
		
	}
	
	@Test
	public void DaniaNaves() {
		
		Proyectil p1 = new Proyectil(new Circulo(new Punto(20, 20), 1), 1);
		Proyectil p2 = new Proyectil(new Circulo(new Punto(20, 20), 1), 0);
		
		Enemigo e1 = new Enemigo(new Circulo(new Punto(21, 21), 1.5), 100, 25, new Angulo(90),
				new Proyectil(new Circulo(new Punto(20, 20), 1), 1));
		Darius d1 = new Darius(100, new Circulo(new Punto(20, 20), 5), 1,
				new Proyectil(new Circulo(new Punto(20, 20), 1), 1));
		
		p1.chocar(e1);
		p2.chocar(d1);
		
		assertEquals(d1.getVidaMax()-p1.getAtaque(), d1.getVida(), 0);
		assertEquals(e1.getVidaMax()-p2.getAtaque(), e1.getVida(), 0);
		
	}
	
	@Test
	public void NoDaniaProyectiles() {
		
		Proyectil p1 = new Proyectil(new Circulo(new Punto(20, 20), 1), 1);
		Proyectil p2 = new Proyectil(new Circulo(new Punto(20, 20), 1), 0);
		
		p1.chocar(p2);
		
		assertEquals(10, p1.getAtaque(), 0);
		assertEquals(10, p2.getAtaque(), 0);
		
	}
	
	
	

}
