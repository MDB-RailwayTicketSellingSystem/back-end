package com.company.project.model;

import java.math.BigDecimal;
import java.time.LocalDate;
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
    private LocalDate traindate;

    @Column(name = "TRAINNUMBER")
    private String trainnumber;

    @Column(name = "STARTORDER")
    private int startorder;

    @Column(name = "ARRIVEORDER")
    private int arriveorder;

    @Column(name = "PRICE")
    private int price;

    @Column(name = "STATE")
    private int state;

    @Column(name = "ORDERDATE")
    private LocalDate ordertime;

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
    public LocalDate getTraindate() {
        return traindate;
    }

    /**
     * @param traindate
     */
    public void setTraindate(LocalDate traindate) {
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
     * @return STARTORDER
     */
    public int getStartorder() {
        return startorder;
    }

    /**
     * @param startorder
     */
    public void setStartorder(int startorder) {
        this.startorder = startorder;
    }

    /**
     * @return ARRIVEORDER
     */
    public int getArriveorder() {
        return arriveorder;
    }

    /**
     * @param arriveorder
     */
    public void setArriveorder(int arriveorder) {
        this.arriveorder = arriveorder;
    }

    /**
     * @return PRICE
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return STATE
     */
    public int getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(int state) {
        this.state = state;
    }

    public LocalDate getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(LocalDate ordertime) {
        this.ordertime = ordertime;
    }
}