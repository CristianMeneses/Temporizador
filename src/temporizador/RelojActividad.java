/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temporizador;

import java.util.Timer;
import java.util.TimerTask;

public class RelojActividad {

    private int actividad;
    private int descanso;
    private Timer timer;
    private RelojDescanso relojD;

    RelojActividad(int actividad, int descanso) {
        timer = new Timer();
        this.actividad = actividad;
        this.descanso = descanso;
    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            if (actividad > 0) {
                actividad--;
            } else {
                System.out.println("actividad acabada");
                timer.cancel();
                timer.purge();
                relojD = new RelojDescanso(descanso);
                relojD.start(0, 1000);
            }
        }
    }; // fin timertask

    public void start(int timeout, int interval) throws InterruptedException {
        timer.schedule(task, timeout, interval);
        Thread.sleep(((1000*actividad) + (1000*descanso)));
    }

} // fin clase
