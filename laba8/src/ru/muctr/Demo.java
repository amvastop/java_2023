package ru.muctr;

import java.util.concurrent.*;

public class Demo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CyclicBarrier barrier = new CyclicBarrier(2);
        CountDownLatch latchForWinner = new CountDownLatch(3);
        Runnable athlete1 = new Athlete(10, "team1", barrier, latchForWinner, "athlete1");
        Runnable athlete2 = new Athlete(100, "team2", barrier, latchForWinner, "athlete2");
        Runnable athlete3 = new Athlete(11, "team1", null, latchForWinner, "athlete3");
        Runnable athlete4 = new Athlete(9, "team2", null, latchForWinner, "athlete4");
        ExecutorService executor = Executors.newFixedThreadPool(2);
        System.out.println("Эстафета началас");
        executor.submit(athlete1);
        executor.submit(athlete2);
        Future<?> ans1 = executor.submit(athlete3);
        Future<?> ans2 = executor.submit(athlete4);
        latchForWinner.await();
        if (ans1.isDone())
            System.out.println("победила команда под номером " + ((Athlete) athlete3).getTeamName());
        else
            System.out.println(ans2);
    }
}
