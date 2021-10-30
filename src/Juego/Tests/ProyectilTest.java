package Juego.Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Juego.Entidades.Darius;
import Juego.Entidades.Enemigo;
import Juego.Entidades.Proyectil;
import Juego.Graficos.RecursosExternos;
import Juego.Utils.Angulo;
import Juego.Utils.Circulo;
import Juego.Utils.Punto;

public class ProyectilTest {

	@Test
	public void MovimientoEnAngulo45() {

		Proyectil p1 = new Proyectil(10, new Circulo(new Punto(0, 0), 1), 1, new Angulo(45), 1, RecursosExternos.laser);

		p1.avanzar();
		assertEquals(Math.cos(45), p1.getCirculo().getX(), 0);
		assertEquals(Math.sin(45), p1.getCirculo().getY(), 0);

	}

	@Test
	public void MovimientoEnAngulo135() {

		Proyectil p1 = new Proyectil(10, new Circulo(new Punto(0, 0), 1), 1, new Angulo(135), 1,
				RecursosExternos.laser);

		p1.avanzar();
		assertEquals(Math.cos(135), p1.getCirculo().getX(), 0);
		assertEquals(Math.sin(135), p1.getCirculo().getY(), 0);

	}

	@Test
	public void MovimientoEnAngulo225() {

		Proyectil p1 = new Proyectil(10, new Circulo(new Punto(0, 0), 1), 1, new Angulo(225), 1,RecursosExternos.laser);

		p1.avanzar();
		assertEquals(Math.cos(225), p1.getCirculo().getX(), 0);
		assertEquals(Math.sin(225), p1.getCirculo().getY(), 0);

	}

	@Test
	public void MovimientoEnAngulo315() {

		Proyectil p1 = new Proyectil(10, new Circulo(new Punto(0, 0), 1), 1, new Angulo(315), 1,RecursosExternos.laser);

		p1.avanzar();
		assertEquals(Math.cos(315), p1.getCirculo().getX(), 0);
		assertEquals(Math.sin(315), p1.getCirculo().getY(), 0);

	}

	@Test
	public void DaniaNaves() {

		Proyectil p1 = new Proyectil(new Circulo(new Punto(20, 20), 1), 1,RecursosExternos.laser);
		Proyectil p2 = new Proyectil(new Circulo(new Punto(20, 20), 1), 0,RecursosExternos.laser);

		Enemigo e1 = new Enemigo(new Circulo(new Punto(21, 21), 1.5), 100, 25, new Angulo(90),
				new Proyectil(new Circulo(new Punto(20, 20), 1), 1,RecursosExternos.laser),RecursosExternos.player,1);
		Darius d1 = new Darius(100, new Circulo(new Punto(20, 20), 5), 1,
				new Proyectil(new Circulo(new Punto(20, 20), 1), 1,RecursosExternos.laser),RecursosExternos.player);

		p1.chocar(e1);
		p2.chocar(d1);

		assertEquals(d1.getVidaMax() - p1.getAtaque(), d1.getVida(), 0);
		assertEquals(e1.getVidaMax() - p2.getAtaque(), e1.getVida(), 0);

	}

	@Test
	public void NoDaniaProyectiles() {

		Proyectil p1 = new Proyectil(new Circulo(new Punto(20, 20), 1), 1,RecursosExternos.laser);
		Proyectil p2 = new Proyectil(new Circulo(new Punto(20, 20), 1), 0,RecursosExternos.laser);

		p1.chocar(p2);

		assertEquals(10, p1.getAtaque(), 0);
		assertEquals(10, p2.getAtaque(), 0);

	}

}
