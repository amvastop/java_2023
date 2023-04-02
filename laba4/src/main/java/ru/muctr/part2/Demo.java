package ru.muctr.part2;;
import java.util.function.BinaryOperator;

import static ru.muctr.part2.MyLambdaToMethod.getAreaRectangle;

public class Demo {
    public static void main(String[] args)
    {
        BinaryOperator <Double> bo = (a, b) -> {if (a > b) return  a; return b; };
        double[] array = {2.5, 3 , 4.5, 5};
        System.out.println(lambdaMethod(bo, array));
        System.out.println(getAreaRectangle(array[0], array[1]));
        System.out.println(new MyLambdaToMethod().getAreaTriangle(array[2], array[3]));
    }
    public static double lambdaMethod(BinaryOperator<Double> bo, double[] array )
    {
        return bo.apply(getAreaRectangle(array[0], array[1]), new MyLambdaToMethod().getAreaTriangle(array[2], array[3]));
    }
}
