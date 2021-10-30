package Juego.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener {
	
	private boolean[] keys = new boolean[256];
	
	public static boolean UP, LEFT, RIGHT, DOWN, SHOOT, SPACE,P;
	public KeyBoard() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void keyTyped(KeyEvent e) {	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
	} 
	public void update() {
		UP= keys[KeyEvent.VK_UP];
		LEFT= keys[KeyEvent.VK_LEFT];
		RIGHT= keys[KeyEvent.VK_RIGHT];
		DOWN= keys[KeyEvent.VK_DOWN];
		SHOOT = keys[KeyEvent.VK_Z];
		SPACE = keys[KeyEvent.VK_SPACE];
		P = keys[KeyEvent.VK_P];
	}

}
