package org.example;

public class MyTimer{
    private final Thread thread;

    public MyTimer(Runnable runnable, long delay) {
        this.thread = new Thread(()-> {
            try {
                Thread.sleep(delay);
                runnable.run();
            } catch (InterruptedException e) {
                // InterruptedException вызывается, когда вызван метод stop()
            }
        });
    }

    public void start() {
        thread.start();
    }

    public void stop() {
        thread.interrupt();
    }
}
