package ru.muctr;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Athlete implements Runnable{
    private double speed;
    private String teamName;
    private String name;
    private CyclicBarrier barrier;
    private CountDownLatch latch;

    public String getTeamName() {
        return teamName;
    }

    public Athlete(double speed, String teamName, CyclicBarrier barrier, CountDownLatch latch, String name)
    {
        this.name = name;
        this.barrier = barrier;
        this.speed = speed;
        this.teamName = teamName;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            if (barrier != null)
                barrier.await();
            System.out.println("начал " + name + " команда " + teamName + new Date());
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        long time =  ( long )(200 / speed) ;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("закнчил " + name + " команда " + teamName + new Date());
        latch.countDown();
    }
}