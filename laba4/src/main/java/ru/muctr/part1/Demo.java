package ru.muctr.part1;

public class Demo {

    public static void main(String[] args) throws Exception {
        Apple apple1 = new Apple(8);
        Apple apple2 = new Apple(12);
        Persimmon persimmon1 = new Persimmon(2.5);
        Persimmon persimmon2 = new Persimmon(3.5);
        Box<?>[] boxes = {new Box<>(apple1, 2), new Box<>(apple2, 15), new Box<>(persimmon1, 10), new Box<>(persimmon2, 20) };
        System.out.println(calculateWeight(boxes));

    }
    public static double calculateWeight(Box<?>[] boxes)
    {
        double sum = 0;
        for (Box<?> box: boxes)
            sum += box.getWeight();
        return  sum;
    }

}
