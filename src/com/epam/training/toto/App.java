package com.epam.training.toto;

import com.epam.training.toto.domain.Round;
import com.epam.training.toto.service.TotoService;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        String filename = "toto.csv";
        System.out.println("Hello");

        double d = Double.valueOf("9 640 Ft".replaceAll("Ft","").replaceAll("\\s+",""));
        System.out.println(d);
        ArrayList<Round> result = TotoService.processFile(filename);
    }
}
