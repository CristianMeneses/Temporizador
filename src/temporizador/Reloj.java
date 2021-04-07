/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temporizador;

import java.util.Timer;
import java.util.TimerTask;

public class Reloj {

    private int actividad;
    private int descanso;
    private Timer timer;
    private boolean isTimerRunning;

    Reloj(int actividad, int descanso) {
        timer = new Timer();
        this.actividad = actividad;
        this.descanso = descanso;
    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            isTimerRunning = true;
            if (actividad > 0) {
                actividad--;
            } else {
                System.out.println("actividad acabada");
                if (descanso > 0) {
                    descanso--;
                } else {
                    System.out.println("descanso acabado");
                    isTimerRunning = false;
                    timer.cancel();
                    timer.purge();
                }
            }

            if (!isTimerRunning) {
                System.out.println("ronda finalizada");
            }
        }
    }; // fin timertask

    public void start(int timeout, int interval) {
        timer.schedule(task, timeout, interval);
    }

} // fin clase
