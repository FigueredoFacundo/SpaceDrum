package Juego.Logica;

import Juego.Entidades.Enemigo;
import Juego.Entidades.Proyectil;
import Juego.Graficos.RecursosExternos;
import Juego.Graficos.VentanaPrincipal;
import Juego.Utils.Angulo;
import Juego.Utils.Circulo;
import Juego.Utils.Punto;

public class Partida {
	private static int alturaDePantalla = 600;
	private static int anchoDePantalla = 800;
	private Mapa mapa;
	private VentanaPrincipal ventana;
	public Partida() {
		Mapa mapa = new Mapa();
		
		
	}
	
	
    public void iniciarPartida() {
    Mapa mapa = new Mapa();
    VentanaPrincipal ventana= new VentanaPrincipal(mapa);
	Enemigo enemigo1 = new Enemigo(new Circulo(new Punto(500, 100), 5), 100, 25, new Angulo(90),
			new Proyectil(new Circulo(new Punto(20, 20), 1), 1,RecursosExternos.laser),RecursosExternos.player);
	
	Enemigo enemigo2 = new Enemigo(new Circulo(new Punto(500, 200), 5), 100, 25, new Angulo(-90),
			new Proyectil(new Circulo(new Punto(20, 20), 1), 1,RecursosExternos.laser),RecursosExternos.player);
	
	Enemigo enemigo3 = new Enemigo(new Circulo(new Punto(500, 400), 5), 40, 25, new Angulo(250),
			new Proyectil(new Circulo(new Punto(20, 20), 1), 1,RecursosExternos.laser),RecursosExternos.player);
	
	Enemigo jefe = new Enemigo(new Circulo(new Punto(500, 450), 5), 1000, 25, new Angulo(90),
			new Proyectil(new Circulo(new Punto(20, 20), 1), 1,RecursosExternos.laser),RecursosExternos.player);
	
	mapa.aniadirEnemigos(1, enemigo1);
	mapa.aniadirEnemigos(1, enemigo2);
	mapa.aniadirEnemigos(1, enemigo3);
	mapa.aniadirEnemigos(1, jefe);
	
	mapa.ataqueEnemigo();
    ventana.iniciar();
    
   }
    public static void main(String[] args) {
		Partida partida = new Partida();
		partida.iniciarPartida();
	}
    
    
	
}