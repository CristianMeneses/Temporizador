/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temporizador;

import java.util.Timer;
import java.util.TimerTask;

public class RelojDescanso {

    private int descanso;
    private Timer timer;
    Sonido sonido;

    RelojDescanso(int descanso) {
        timer = new Timer();
        this.descanso = descanso;
        sonido = new Sonido();

    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            if (descanso > 0) {
                descanso--;
                if (descanso < 3) {
                    sonido.ReproducirSonidoSuave();
                }
            } else {
                System.out.println("descanso acabado");
                sonido.ReproducirSonidoFuerte();
                timer.cancel();
                timer.purge();

            }
        }
    }; // fin timertask

    public void start(int timeout, int interval) {
        timer.schedule(task, timeout, interval);
    }

} // fin clase

