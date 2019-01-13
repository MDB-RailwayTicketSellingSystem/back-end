package com.company.project.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.DoubleToIntFunction;

public class TrainResult {

    public SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

    public String trainnumber;

    public int startorder;
    public int arriveorder;

    public String startstation;
    public String arrivestation;

    public Date traindate;
    public String traindateresult;

    public Date arrivetime;
    public String arrivetimeresult;

    public Date leavetime;
    public String leavetimeresult;

    public int remainingseat;

    public int duration;
    //public String durationresult;

    public int price;

}
