package VirenSchleuder;

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

	public Sound() {
		start(this);
	}

	public void start(final Sound sound) {

		Thread thread = new Thread() {
			public void run() {
				play();
			}
		};

		thread.start();

	}

	void play() {
		// String audioFilePath =
		// ClassLoader.getSystemResource("images/Failing_Defense.wav");
		// System.out.println(audioFilePath);
		InputStream stream = this.getClass().getClassLoader()
				.getResourceAsStream("images/Failing_Defense.wav");
		// File audioFile = new File(url.getFile());

		try {
			AudioInputStream audioStream = AudioSystem
					.getAudioInputStream(new BufferedInputStream(stream));

			AudioFormat format = audioStream.getFormat();

			DataLine.Info info = new DataLine.Info(Clip.class, format);

			Clip audioClip = (Clip) AudioSystem.getLine(info);

			audioClip.addLineListener(this);

			audioClip.open(audioStream);

			audioClip.loop(Integer.MAX_VALUE);

			while (!playCompleted) {
				// wait for the playback completes
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
		LineEvent.Type type = event.getType();

		if (type == LineEvent.Type.START) {
			System.out.println("Playback started.");

		} else if (type == LineEvent.Type.STOP) {

			System.out.println("Playback completed.");
		}

	}

}