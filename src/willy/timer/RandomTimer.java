/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package willy.timer;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class RandomTimer {

    private class RandomTimerTask extends TimerTask {

        protected RandomTimerTask() {
            super();
        }

        @Override
        public void run() {
            new Thread(todo).start();
            t.schedule(new RandomTimerTask(), (rr.min + new Random().nextInt(rr.max + 1)) * 1000);
        }

    }

    private final Timer t = new Timer();
    private final Runnable todo;
    private final RandomTimerRange rr;

    public RandomTimer(final Runnable todo, final RandomTimerRange rr) {
        this.rr = rr;
        this.todo = todo;
//        this.tt = new RandomTimerTask(todo, this);
    }

    public void start() {
        this.t.schedule(new RandomTimerTask(), (this.rr.min + new Random().nextInt(this.rr.max + 1)) * 1000);
    }

    public void stop() {
        this.t.cancel();
        this.t.purge();
    }

}
