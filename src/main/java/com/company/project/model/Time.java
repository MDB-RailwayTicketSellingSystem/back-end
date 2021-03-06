package com.company.project.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

public class Time {
    @Id
    @Column(name = "TRAINNUMBER")
    private String trainnumber;

    @Column(name = "STATIONORDER")
    private BigDecimal stationorder;

    @Column(name = "STATION")
    private String station;

    @Column(name = "ARRIVETIME")
    private Date arrivetime;

    @Column(name = "LEAVETIME")
    private Date leavetime;

    @Column(name = "DURATION")
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
}