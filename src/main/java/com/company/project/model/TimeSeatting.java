package com.company.project.model;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

public class TimeSeatting {

    private String trainnumber;


    private BigDecimal stationorder;


    private String station;


    private Date arrivetime;


    private Date leavetime;


    private Date duration;

    /**
     * @return TRAINNUMBER
     */
    public String getTrainnumber() {
        return trainnumber;
    }

    /**
     * @param trainnumber
     */
    public void setTrainnumber(String trainnumber) {
        this.trainnumber = trainnumber;
    }

    /**
     * @return STATIONORDER
     */
    public BigDecimal getStationorder() {
        return stationorder;
    }

    /**
     * @param stationorder
     */
    public void setStationorder(BigDecimal stationorder) {
        this.stationorder = stationorder;
    }

    /**
     * @return STATION
     */
    public String getStation() {
        return station;
    }

    /**
     * @param station
     */
    public void setStation(String station) {
        this.station = station;
    }

    /**
     * @return ARRIVETIME
     */
    public Date getArrivetime() {
        return arrivetime;
    }

    /**
     * @param arrivetime
     */
    public void setArrivetime(Date arrivetime) {
        this.arrivetime = arrivetime;
    }

    /**
     * @return LEAVETIME
     */
    public Date getLeavetime() {
        return leavetime;
    }

    /**
     * @param leavetime
     */
    public void setLeavetime(Date leavetime) {
        this.leavetime = leavetime;
    }

    /**
     * @return DURATION
     */
    public Date getDuration() {
        return duration;
    }

    /**
     * @param duration
     */
    public void setDuration(Date duration) {
        this.duration = duration;
    }


    private Short remainingseat;


    private Date traindate;


    /**
     * @return REMAININGSEAT
     */
    public Short getRemainingseat() {
        return remainingseat;
    }

    /**
     * @param remainingseat
     */
    public void setRemainingseat(Short remainingseat) {
        this.remainingseat = remainingseat;
    }

    /**
     * @return TRAINDATE
     */
    public Date getTraindate() {
        return traindate;
    }

    /**
     * @param traindate
     */
    public void setTraindate(Date traindate) {
        this.traindate = traindate;
    }
}
