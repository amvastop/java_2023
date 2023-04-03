package ru.muctr.part1;

public class Demo {

    public static void main(String[] args) throws Exception {
        Apple apple1 = new Apple(8);
        Apple apple2 = new Apple(12);
        Persimmon persimmon1 = new Persimmon(2.5);
        Persimmon persimmon2 = new Persimmon(3.5);
        Box<Apple> box1 = new Box<>(apple1, 4);
        Box<Apple> box2 = new Box<>(apple2, 15);
        Box<Persimmon> box3 =  new Box<>(persimmon1, 10);
        Box<Persimmon> box4 =  new Box<>(persimmon2, 20);
        Box<?>[] boxes = {box1, box2, box3, box4 };
        box1.shiftFruit(box2, 3);
        System.out.println(box1);
        System.out.println(box2);
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
