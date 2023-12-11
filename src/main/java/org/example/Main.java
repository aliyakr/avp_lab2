package org.example;

import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AtomicBoolean ran = new AtomicBoolean(false);
        MyTimer myTimer = new MyTimer(() -> ran.set(true), 1000);
        myTimer.start();

        Thread.sleep(500);
        if (ran.get()) {
            throw new AssertionError("Задача запустилась слишком рано");
        }

        Thread.sleep(700);
        if (!ran.get()) {
            throw new AssertionError("Задача не запустилась");
        }

        ran.set(false);
        MyTimer myTimer1 = new MyTimer(() -> ran.set(true), 1000);
        myTimer1.start();

        Thread.sleep(500);
        myTimer1.stop();

        Thread.sleep(700);
        if (ran.get()) {
            throw new AssertionError("Задача не прервалась после того как была запущена");
        }
    }
}
