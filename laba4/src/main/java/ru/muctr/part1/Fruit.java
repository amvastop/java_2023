package ru.muctr.part1;

import lombok.Getter;

@Getter
public abstract class Fruit {
    double weight;

    public Fruit(double weight) throws Exception {
        if (weight <= 0)
            throw new Exception("значения должно быть больше 0");
        this.weight = weight;
    }

    public void setWeight(double weight) throws Exception
    {
        if (weight <= 0)
            throw new Exception("значения должно быть больше 0");
        weight = weight;
    }


}
