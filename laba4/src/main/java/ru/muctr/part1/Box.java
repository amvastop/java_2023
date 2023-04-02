package ru.muctr.part1;

import lombok.Getter;

@Getter
public class Box <T extends Fruit>{
    private T fruit;
    private int number = 0;


    public Box(T fruit, int number) throws Exception {
        this.fruit = fruit;
        if (number <= 0)
            throw new Exception("значения должно быть больше 0");
        this.number = number;
    }

    public double getWeight()
    {
        return fruit.getWeight() * number;
    }

    public void shiftFruit(Box<T> box)
    {
        fruit = box.getFruit();
        number = box.getNumber();
    }

}
