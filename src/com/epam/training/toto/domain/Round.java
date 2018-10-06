package com.epam.training.toto.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Round {
    //2015;44;1;2015.10.29.;23;76 500 Ft;46;9 640 Ft;1410;355 Ft;7800;185 Ft;18990;0 Ft;2;1;1;1;2;2;2;1;2;1;1;1;1;+2
    private int year;
    private int week;
    private int round;
    private LocalDate date;
    private HashMap<Integer,Hit> hits;
    private ArrayList<Outcome> outcomes;

    public Round(int year, int week, int round, LocalDate date, HashMap<Integer,Hit> hits, ArrayList<Outcome> outcomes) {
        this.year = year;
        this.week = week;
        this.round = round;
        this.date = date;
        this.hits = hits;
        this.outcomes = outcomes;
    }
    public Round(int year, int week, int round, String date, HashMap<Integer,Hit> hits, ArrayList<Outcome> outcomes) {
        this(year,week,round,LocalDate.parse(date,DateTimeFormatter.ofPattern("yyyy.MM.dd.")), hits, outcomes);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public HashMap<Integer,Hit> getHits() {
        return hits;
    }

    public void setHits(HashMap<Integer,Hit> hits) {
        this.hits = hits;
    }
    public void addHit(Hit hit) {
        this.hits.replace(hit.getHitType(),hit);
    }
    public Hit getHit (int hitType) {
        return this.hits.get(hitType);
    }

    public ArrayList<Outcome> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(ArrayList<Outcome> outcomes) {
        this.outcomes = outcomes;
    }
}
