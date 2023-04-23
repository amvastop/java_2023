package ru.muctr;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TVSet {
    private int id;
    private String name;
    private String brand;
    private double diagonal;
    private double price;
    private double grade;

    public TVSet(String[] args)
    {
        id = Integer.parseInt(args[0]);
        name = args[1];
        brand = args[2];
        diagonal = Double.parseDouble(args[3]);
        price = Double.parseDouble(args[4]);
        grade = Double.parseDouble(args[5].replace(',','.'));
    }

}
