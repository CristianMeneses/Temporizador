/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temporizador;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class RelojActividad {

    private int actividad;
    private int descanso;
    private Timer timer;
    private RelojDescanso relojD;
    Sonido sonido;

    RelojActividad(int actividad, int descanso) {
        timer = new Timer();
        this.actividad = actividad;
        this.descanso = descanso;
        sonido = new Sonido();
    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            if (actividad > 0) {
                actividad--;
                if (actividad < 3) {
                    sonido.ReproducirSonidoSuave();
                }
            } else {
                System.out.println("actividad acabada");
                sonido.ReproducirSonidoFuerte();
                timer.cancel();
                timer.purge();
                relojD = new RelojDescanso(descanso);
                relojD.start(0, 1000);
            }
        }
    }; // fin timertask

    public void start(int timeout, int interval) throws InterruptedException {
        timer.schedule(task, timeout, interval);
        Thread.sleep(((1000 * actividad) + (1000 * descanso)));
    }

} // fin clase
