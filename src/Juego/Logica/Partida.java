package logica;

import Juego.Entidades.*;
import Juego.Utils.*;

public class Partida {
	private static int alturaDePantalla = 600;
	private static int anchoDePantalla = 800;

	private Mapa mapa = new Mapa();
	
	
    public void iniciarPartida() {
	Enemigo enemigo1 = new Enemigo(new Circulo(new Punto(300, alturaDePantalla), 5), 100, 25, new Angulo(90),
			new Proyectil(new Circulo(new Punto(20, 20), 1), 1));
	
	Enemigo enemigo2 = new Enemigo(new Circulo(new Punto(300, 0), 5), 100, 25, new Angulo(-90),
			new Proyectil(new Circulo(new Punto(20, 20), 1), 1));
	
	Enemigo enemigo3 = new Enemigo(new Circulo(new Punto(anchoDePantalla, 100), 5), 40, 25, new Angulo(250),
			new Proyectil(new Circulo(new Punto(20, 20), 1), 1));
	
	Enemigo jefe = new Enemigo(new Circulo(new Punto(300, 600), 5), 1000, 25, new Angulo(90),
			new Proyectil(new Circulo(new Punto(20, 20), 1), 1));
	
	mapa.añadirEnemigos(10, enemigo1);
	mapa.añadirEnemigos(5, enemigo2);
	mapa.añadirEnemigos(20, enemigo3);
	mapa.añadirEnemigos(1, jefe);
	
	mapa.ataqueEnemigo();
    
   }
    
    
    
	
}
