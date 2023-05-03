package ru.muctr;

import java.util.concurrent.*;

public class Demo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CyclicBarrier barrier = new CyclicBarrier(2);
        CountDownLatch latchForWinner = new CountDownLatch(3);
        Runnable athlete1 = new Athlete(32, "team1", barrier, latchForWinner, "athlete1");
        Runnable athlete2 = new Athlete(30, "team2", barrier, latchForWinner, "athlete2");
        Runnable athlete3 = new Athlete(31, "team1", null, latchForWinner, "athlete3");
        Runnable athlete4 = new Athlete(40, "team2", null, latchForWinner, "athlete4");
        try(ExecutorService executor = Executors.newFixedThreadPool(2))
            {
                System.out.println("Эстафета началас");
                executor.submit(athlete1);
                executor.submit(athlete2);
                Future<?> resultAthlete3 = executor.submit(athlete3);
                executor.submit(athlete4);
                latchForWinner.await();
                Athlete ans;
                if (resultAthlete3.isDone())
                    ans = (Athlete) athlete3;
                else
                    ans = (Athlete) athlete4;
                System.out.println("победила команда под номером " + ans.getTeamName());
                executor.shutdown();
            }

    }
}
