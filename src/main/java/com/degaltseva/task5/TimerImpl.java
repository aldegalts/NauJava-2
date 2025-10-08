package com.degaltseva.task5;

public class TimerImpl implements ITimer {
    private int seconds;
    private boolean isRunning;
    private Thread timerThread;

    public TimerImpl(int seconds) {
        this.seconds = seconds;
        this.isRunning = false;
    }

    @Override
    public void start() {
        if (!isRunning) {
            isRunning = true;
            timerThread = new Thread(() -> {
                try {
                    while (seconds > 0 && isRunning) {
                        System.out.println("Осталось: " + seconds + " секунд");
                        Thread.sleep(1000);
                        seconds--;
                    }
                    if (seconds == 0 && isRunning) {
                        System.out.println("Таймер завершился!");
                    }
                } catch (InterruptedException e) {
                    System.out.println("Таймер был прерван!");
                }
            });
            timerThread.start();
        }
    }

    @Override
    public void stop() {
        isRunning = false;
        if (timerThread != null) {
            timerThread.interrupt();
        }
    }
}