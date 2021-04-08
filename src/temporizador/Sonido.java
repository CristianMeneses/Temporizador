/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temporizador;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author USER
 */
public class Sonido {

    public void ReproducirSonidoSuave() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\camar\\Desktop\\Temporizador\\Sonidos\\Beep_Suave.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

        } catch (Exception e) {
            System.out.println("Error al reproducir audio");
        }
    }
    public void ReproducirSonidoFuerte() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\camar\\Desktop\\Temporizador\\Sonidos\\Beep_Fuerte.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

        } catch (Exception e) {
            System.out.println("Error al reproducir audio");
        }
    }
}
