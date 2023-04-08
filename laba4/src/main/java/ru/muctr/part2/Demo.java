package ru.muctr.part2;

import java.util.function.BinaryOperator;
import java.util.function.Function;

import static ru.muctr.part2.MyLambdaToMethod.getAreaRectangle;

public class Demo {
    public static void main(String[] args)
    {
        double[] arrayDouble = {2.0, 3.0};
        BinaryOperator<Double> bo = (a, b) ->  a > b ? a : b ;
        System.out.println(lambdaMethod(MyLambdaToMethod::getAreaRectangle, arrayDouble));
        System.out.println(lambdaMethod(bo, arrayDouble));
        System.out.println(lambdaMethod(new MyLambdaToMethod()::getAreaTriangle, arrayDouble));

    }
    public static double lambdaMethod(BinaryOperator<Double> bo, double[] array )
    {
        return bo.apply(array[0], array[1]);
    }
}
