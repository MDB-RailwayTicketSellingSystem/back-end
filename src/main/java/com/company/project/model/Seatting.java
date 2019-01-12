package com.company.project.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Seatting {
    @Id
    @Column(name = "TRAINNUMBER")
    private String trainnumber;

    @Column(name = "STATIONORDER")
    private Short stationorder;

    @Column(name = "REMAININGSEAT")
    private Short remainingseat;

    @Column(name = "TRAINDATE")
    private Date traindate;

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
    public Short getStationorder() {
        return stationorder;
    }

    /**
     * @param stationorder
     */
    public void setStationorder(Short stationorder) {
        this.stationorder = stationorder;
    }

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