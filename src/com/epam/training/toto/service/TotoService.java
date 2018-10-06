package com.epam.training.toto.service;

import com.epam.training.toto.domain.Hit;
import com.epam.training.toto.domain.Outcome;
import com.epam.training.toto.domain.Round;


import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TotoService {

    private static Function<String, Round> lineToObject = (line) -> {
        String[] p = line.split(";");
        //2015;
        int year = Integer.parseInt(p[0]);
        //44;
        int week = Integer.parseInt(p[1]);
        //1;
        int round = Integer.parseInt(p[2].replaceAll("-", "1"));
        //23;76 500 Ft; 46;9 640 Ft; 1410;355 Ft; 7800;185 Ft; 18990;0 Ft
        HashMap<Integer, Hit> hits = new HashMap<Integer, Hit>(4);
        int j = 4;
        for (int i = 14; i > 9; i--) {
            hits.put(i, new Hit(i, Integer.parseInt(p[j]), Double.valueOf(p[++j].replaceAll("Ft", "").replaceAll("\\s+", ""))));
            j++;
        }
        //2;1;1;1;2;2;2;1;2;1;1;1;1;+2
        ArrayList<Outcome> outcomes = new ArrayList<Outcome>(14);
        for (int i = 14; i < p.length; i++) {
            switch (p[i].replaceAll("[+]", "")) {
                case "1":
                    outcomes.add(Outcome.ONE);
                    break;
                case "2":
                    outcomes.add(Outcome.TWO);
                    break;
                case "X":
                    outcomes.add(Outcome.DRAW);
                    break;
            }
        }
        //2015.10.29.;
        if (p[3].equals("")) {
            return new Round(year, week, round, LocalDate.of(year,1,1).plusWeeks(week).with(DayOfWeek.SUNDAY), hits, outcomes);
        } else {
            return new Round(year, week, round, p[3], hits, outcomes);
        }

    };

    public static ArrayList<Round> processFile(String filepath) {
        ArrayList<Round> result = new ArrayList<Round>();

        try {
            File file = new File(filepath);
            InputStream inputStream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            result = (ArrayList<Round>) br.lines().map(lineToObject).collect(Collectors.toList());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
