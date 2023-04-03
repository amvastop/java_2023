package ru.muctr.part1;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
public class Box <T extends Fruit>{
    private T fruit;
    private int number = 0;


    public Box(T fruit, int number) throws Exception {
        this.fruit = fruit;
        if (number < 0)
            throw new Exception("значения должно быть больше bkb равен 0");
        this.number = number;
    }

    public double getWeight()
    {
        return fruit.getWeight() * number;
    }

    public void setNumber(int number) throws Exception {
        if(number < 0)
            throw new Exception("количесво не может быть меньше 0");
        this.number = number;
    }

    public void shiftFruit(Box<T> box, int count) throws Exception {
        if(count < 0 || box.getNumber() - count < 0)
            throw new Exception("количесво не может быть меньше 0");
        fruit = box.getFruit();
        number += count;
        box.setNumber(box.getNumber() - count);
    }

}
