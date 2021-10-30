package Juego.Utils;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sonido {

	Clip clip;

	public Sonido(String path) throws Exception {
		AudioInputStream audioIn = AudioSystem.getAudioInputStream(Sonido.class.getResource(path));
		clip = AudioSystem.getClip();
		clip.open(audioIn);
	}

	public void play() {
		clip.stop();
		clip.flush();
		clip.setMicrosecondPosition(0);
		clip.start();
	}

	public void setVolume(float volume) {
		if (volume < 0f || volume > 1f)
			throw new IllegalArgumentException("Volume not valid: " + volume);
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(20f * (float) Math.log10(volume));
	}
}
