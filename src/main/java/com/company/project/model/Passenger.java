package com.company.project.model;

import java.math.BigDecimal;
import javax.persistence.*;

public class Passenger {
    @Id
    @Column(name = "ACCOUNTID")
    private String accountid;

    @Column(name = "ACCOUNTTYPE")
    private BigDecimal accounttype;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "CARDID")
    private String cardid;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

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
     * @return ACCOUNTTYPE
     */
    public BigDecimal getAccounttype() {
        return accounttype;
    }

    /**
     * @param accounttype
     */
    public void setAccounttype(BigDecimal accounttype) {
        this.accounttype = accounttype;
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
     * @return PHONE
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return CARDID
     */
    public String getCardid() {
        return cardid;
    }

    /**
     * @param cardid
     */
    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    /**
     * @return PASSWORD
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return EMAIL
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}