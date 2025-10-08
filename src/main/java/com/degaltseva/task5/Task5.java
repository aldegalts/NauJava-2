package com.degaltseva.task5;

import com.degaltseva.MyRunnable;

public class Task5 implements MyRunnable {
    private final ITimer timer;

    public Task5(int seconds) {
        this.timer = new TimerImpl(seconds);
    }

    @Override
    public void run() {
        timer.start();
        try {
            Thread.sleep(3000);
            timer.stop();
        } catch (InterruptedException e) {
            System.err.println("Ошибка в Task5: " + e.getMessage());
        }
    }
}