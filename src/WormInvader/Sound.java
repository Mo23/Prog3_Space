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

public class Sound extends Thread implements LineListener {

	protected boolean playCompleted;
	private InputStream backgroundmusic = this.getClass().getClassLoader().getResourceAsStream("images/Failing_Defense.wav");
	private InputStream shotfired = this.getClass().getClassLoader().getResourceAsStream("images/Laser_Blaster.wav");

	public Sound(final int n) {
		start(this,n);
	}

	public void start(final Sound sound, final int n) {

		Thread thread = new Thread() {
			public void run() {
				if(n==0){
				play(backgroundmusic, n);}
				else{
					play(shotfired,n);
				}
			}
		};

		thread.start();

	}

	void play(InputStream stream, final int n) {
		

		try {
			AudioInputStream audioStream = AudioSystem
					.getAudioInputStream(new BufferedInputStream(stream));

			AudioFormat format = audioStream.getFormat();

			DataLine.Info info = new DataLine.Info(Clip.class, format);

			Clip audioClip = (Clip) AudioSystem.getLine(info);

			audioClip.addLineListener(this);

			audioClip.open(audioStream);
			if(n==0){
			audioClip.loop(Integer.MAX_VALUE);}
			else{
				
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

	@Override
	public void update(LineEvent event) {
		

	}

}