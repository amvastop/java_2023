package ru.muctor;

import java.util.Arrays;

public class SimpleMethods {
    public static boolean isArrayEqual(int[] array1, int[] array2) // O(n*log(n))
    {
        Arrays.sort(array1);
        Arrays.sort(array2); // возможно примение set для ускорения работы проаммы
        if (array1.length != array2.length)
            return  false;
        for(int i = 0; i < array1.length; i++)
            if(array2[i] != array1[i])
                return false;
        return true;
    }
    public double average(int[] array)
    {
        double sum = 0;
        for (int j : array) sum += j;
        return sum / array.length;

    }
    public static String[] splitSpace (String str) {
        int resultSize = 0;
        int next = 0;
        int prev = 0;
        int length = str.length();
        while ((next = str.indexOf(' ', prev)) != -1) {
            if (next > prev )
                resultSize++;
            prev = next + 1;
        }
        if (prev != length)
            resultSize++;
        String[] result = new String[resultSize];
        prev = 0;
        System.out.println(resultSize);
        int i = 0;
        while ((next = str.indexOf(' ', prev)) != -1) {
            if (next > prev ) {
                result[i] = str.substring(prev, next);
                i++;
            }
            prev = next + 1;
        }
        if (resultSize > i)
            result[resultSize - 1] = str.substring(prev);
       return result;
    }


}
