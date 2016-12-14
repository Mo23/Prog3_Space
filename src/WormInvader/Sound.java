package WormInvader;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * @author maurice
 *
 */
public class Sound extends Thread implements LineListener {

	protected boolean playCompleted;
	private InputStream backgroundmusic = this.getClass().getClassLoader()
			.getResourceAsStream("images/Background_Music.wav");
	private InputStream shotfired = this.getClass().getClassLoader()
			.getResourceAsStream("images/Laser_Blaster.wav");
	private InputStream playerhit = this.getClass().getClassLoader()
			.getResourceAsStream("images/Player_Hit.wav");
	private InputStream wormhit = this.getClass().getClassLoader()
			.getResourceAsStream("images/Worm_Hit.wav");

	/**
	 * Konstruktor des Sounds mit angabe der Abspielart.
	 * @param n
	 */
	public Sound(final int n) {
		start(this, n);
	}

	/**
	 * Startet neuen Ton mit Auswahl welcher gespielt werden soll.
	 * @param sound
	 * @param n
	 */
	public void start(final Sound sound, final int n) {

		Thread thread = new Thread() {
			public void run() {
				if (n == 0) {
					play(backgroundmusic, n);
				} else if (n == 1) {
					play(shotfired, n);
				} else if (n == 2) {
					play(playerhit, n);
				} else if (n == 3) {
					play(wormhit, n);
				}
			}
		};

		thread.start();

	}

	/**
	 * Nimmmt den zu spielenden Tonstream entgegen und die Auswahl der dauer.
	 * @param stream
	 * @param n
	 */
	void play(InputStream stream, final int n) {

		try {
			AudioInputStream audioStream = AudioSystem
					.getAudioInputStream(new BufferedInputStream(stream));

			AudioFormat format = audioStream.getFormat();

			DataLine.Info info = new DataLine.Info(Clip.class, format);

			Clip audioClip = (Clip) AudioSystem.getLine(info);

			audioClip.addLineListener(this);

			audioClip.open(audioStream);
			if (n == 0) {
				audioClip.loop(Integer.MAX_VALUE);
			} else {

				audioClip.start();
			}

			while (!playCompleted) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}

			audioClip.close();

		} catch (UnsupportedAudioFileException ex) {
			System.out.println("The specified audio file is not supported.");
			ex.printStackTrace();
		} catch (LineUnavailableException ex) {
			System.out.println("Audio line for playing back is unavailable.");
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println("Error playing the audio file.");
			ex.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * @see javax.sound.sampled.LineListener#update(javax.sound.sampled.LineEvent)
	 */
	@Override
	public void update(LineEvent event) {

	}

}