package ru.muctr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.*;

public class Demo {
    public static void main(String[] args) throws IOException {
        List<TVSet> arrayListTVSet = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("src/вар.3.txt")))
        {
            br.readLine();
            String lineString;
            while ((lineString = br.readLine()) != null)

            {
                String[] splitArray = lineString.split("\t");
                arrayListTVSet.add(new TVSet(splitArray));
            }
        }

        arrayListTVSet.stream().sorted(comparing(TVSet::getName)).forEach(System.out::print);
        System.out.println();
        arrayListTVSet.stream().sorted(comparing(TVSet::getPrice)).forEach(System.out::print);
        System.out.println();
        Optional<TVSet> maxPrise = arrayListTVSet.stream().max(comparing(TVSet::getPrice));
        List<TVSet> listGradeGt4_5 = arrayListTVSet.stream().filter(x-> x.getGrade() > 4.5).collect(toList());
        System.out.println(listGradeGt4_5);
        OptionalDouble avgPrise = arrayListTVSet.stream().mapToDouble(TVSet::getPrice).average();
        System.out.println(avgPrise.orElse(2));
        Optional<TVSet> cheapPrise = arrayListTVSet.stream().filter(x-> x.getDiagonal() == 32).min(comparing(TVSet::getPrice));
        System.out.println(cheapPrise);
        boolean flag = arrayListTVSet.stream().noneMatch(x-> x.getGrade() < 4);
        System.out.println(flag);
        boolean flag1 = arrayListTVSet.stream().anyMatch(x-> x.getPrice() > 30);
        System.out.println(flag1);
        Optional<TVSet> maxPrise2 = arrayListTVSet.stream().collect(Collectors.maxBy(comparing(TVSet::getPrice)));
        System.out.println(maxPrise2);
        Map<Boolean, List<TVSet>> diagonalTVSet = arrayListTVSet.stream().collect(partitioningBy(x-> x.getDiagonal() > 30));
        Map<String, List<TVSet>> groupByBrand = arrayListTVSet.stream().collect(groupingBy(TVSet::getBrand));
        Map<String, Long> countGrope = arrayListTVSet.stream().collect(groupingBy(TVSet::getBrand, counting()));
        Map<String, Double> avgGrope = arrayListTVSet.stream().collect(groupingBy(TVSet::getBrand, averagingDouble(TVSet::getPrice)));
        String str1 = arrayListTVSet.stream().filter(x-> x.getPrice() >= 10000 && x.getPrice() <= 15000).sorted(comparing(TVSet::getPrice)).
                map(TVSet::getName).collect(joining(", ", "Модели телевизоров стоимостью от 10 до 15 тыс. руб.: ", "."));
        System.out.println(str1);
    }
}

