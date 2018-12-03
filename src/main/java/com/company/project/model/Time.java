package com.company.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Time {
    @Id
    @Column(name = "TRAINID")
    private String trainid;

    @Column(name = "TRAINNUMBER")
    private String trainnumber;

    @Column(name = "STATIONORDER")
    private BigDecimal stationorder;

    @Column(name = "STATION")
    private String station;

    @Column(name = "TRAINDATE")
    private Date traindate;

    @Column(name = "ARRIVETIME")
    private Date arrivetime;

    @Column(name = "LEAVETIME")
    private Date leavetime;

    @Column(name = "REMAININGSEAT")
    private BigDecimal remainingseat;

    @Column(name = "DURATION")
    private Date duration;

    /**
     * @return TRAINID
     */
    public String getTrainid() {
        return trainid;
    }

    /**
     * @param trainid
     */
    public void setTrainid(String trainid) {
        this.trainid = trainid;
    }

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
     * @return REMAININGSEAT
     */
    public BigDecimal getRemainingseat() {
        return remainingseat;
    }

    /**
     * @param remainingseat
     */
    public void setRemainingseat(BigDecimal remainingseat) {
        this.remainingseat = remainingseat;
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
}