package ru.muctr;

import lombok.*;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Patent {
    private String title;
    private String number;
    private Date date;
    private List<String> inventors;
    private List<String> companies;
    private List<String> mpk;
    public Patent(String[] args ) {
        title = args[0];
        number = args[1];
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(args[2]);
        }
        catch (ParseException e)
        {
            System.out.println(args[2]);
        }
        inventors = Arrays.asList(args[3].split("; "));
        companies = Arrays.asList(args[4].split("; "));
        mpk = Arrays.asList(args[5].split("; "));
    }
}
