package com.company.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Trainorder {
    @Id
    @Column(name = "ORDERID")
    private String orderid;

    @Column(name = "ACCOUNTID")
    private String accountid;

    @Column(name = "PASSENGERCARD")
    private String passengercard;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TRAINDATE")
    private Date traindate;

    @Column(name = "TRAINNUMBER")
    private String trainnumber;

    @Column(name = "STARTLOCATION")
    private String startlocation;

    @Column(name = "ARRIVELOCATION")
    private String arrivelocation;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "STATE")
    private BigDecimal state;

    /**
     * @return ORDERID
     */
    public String getOrderid() {
        return orderid;
    }

    /**
     * @param orderid
     */
    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    /**
     * @return ACCOUNTID
     */
    public String getAccountid() {
        return accountid;
    }

    /**
     * @param accountid
     */
    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    /**
     * @return PASSENGERCARD
     */
    public String getPassengercard() {
        return passengercard;
    }

    /**
     * @param passengercard
     */
    public void setPassengercard(String passengercard) {
        this.passengercard = passengercard;
    }

    /**
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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
     * @return STARTLOCATION
     */
    public String getStartlocation() {
        return startlocation;
    }

    /**
     * @param startlocation
     */
    public void setStartlocation(String startlocation) {
        this.startlocation = startlocation;
    }

    /**
     * @return ARRIVELOCATION
     */
    public String getArrivelocation() {
        return arrivelocation;
    }

    /**
     * @param arrivelocation
     */
    public void setArrivelocation(String arrivelocation) {
        this.arrivelocation = arrivelocation;
    }

    /**
     * @return PRICE
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return STATE
     */
    public BigDecimal getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(BigDecimal state) {
        this.state = state;
    }
}