package Juego.Logica;

import Juego.Entidades.Enemigo;
import Juego.Entidades.Proyectil;
import Juego.Graficos.RecursosExternos;
import Juego.Graficos.VentanaPrincipal;
import Juego.Utils.Angulo;
import Juego.Utils.Circulo;
import Juego.Utils.Punto;

public class Partida {
	

	public Partida() {
		
		
		
	}
	
	
    public void iniciarPartida() {
    RecursosExternos.init();
    Mapa mapa = new Mapa();
    VentanaPrincipal ventana= new VentanaPrincipal(mapa);
	Enemigo enemigo1 = new Enemigo(new Circulo(new Punto(500, -50), 20), 100, 25, new Angulo(110),
			new Proyectil(new Circulo(new Punto(20, 20), 1), -1,RecursosExternos.laserRed),RecursosExternos.enemigo,2);
	
	Enemigo enemigo2 = new Enemigo(new Circulo(new Punto(500, 700), 30), 150, 25, new Angulo(270),
			new Proyectil(new Circulo(new Punto(20, 20), 1), -1,RecursosExternos.laserRed),RecursosExternos.enemigo2,3);
	
	Enemigo enemigo3 = new Enemigo(new Circulo(new Punto(500, 600), 35), 40, 25, new Angulo(180),
			new Proyectil(new Circulo(new Punto(20, 20), 1), -1,RecursosExternos.laserRed),RecursosExternos.enemigo3,1);
	
	Enemigo jefe = new Enemigo(new Circulo(new Punto(500, 450), 50), 1000, 40, new Angulo(0),

			new Proyectil(new Circulo(new Punto(20, 20), 1), -1,RecursosExternos.laserRed),RecursosExternos.enemigo4,0);
	ventana.iniciar();
	mapa.aniadirEnemigos(8, enemigo1);

	
	mapa.aniadirEnemigos(4, enemigo2);
	mapa.aniadirEnemigos(3, enemigo3);
	mapa.aniadirEnemigos(1, jefe);
	
	
	mapa.ataqueEnemigo();
	
    
    
   }
    public static void main(String[] args) {
		Partida partida = new Partida();
		partida.iniciarPartida();
	}
    
    
	
}