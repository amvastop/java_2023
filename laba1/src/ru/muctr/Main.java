package ru.muctr;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final int N = 10000;
        Random random = new Random();
        int[] arrayInt1 = new int[N];
        for (int i = 0; i < N; i++)
            arrayInt1[i] = random.nextInt();
        int[] arrayInt12 = Arrays.copyOf(arrayInt1, arrayInt1.length);
        long start = System.currentTimeMillis();
        Arrays.sort(arrayInt1);
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        insertionSort(arrayInt12);
        System.out.println(System.currentTimeMillis() - start);
//        System.out.println(Arrays.toString(arrayInt12));
        String str = "  123  123  1 1   13 1";
        String[] strs = str.split(" ");
        split_space(str);
        for (String element :strs) {
            System.out.print(element);
        }


    }
    public static void insertionSort(int[] sortArr) {
        //сортировку начинаем со второго элемента, т.к. считается, что первый элемент уже отсортирован
        for (int i = 1; i < sortArr.length; i++) {
            //сохраняем ссылку на индекс предыдущего элемента
            for (int j = i; j > 0 && sortArr[j] < sortArr[j - 1]; j--) {
                //элементы отсортированного сегмента перемещаем вперёд, если они больше элемента для вставки
                int tmp = sortArr[j - 1];
                sortArr[j - 1] = sortArr[j];
                sortArr[j] = tmp;
            }
        }
    }
    public  static void split_space (String str) {
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
        System.out.println(Arrays.toString(result));
    }
}