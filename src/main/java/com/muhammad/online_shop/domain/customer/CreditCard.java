package com.muhammad.online_shop.domain.customer;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private String holderName;
    private String number;
    private int CC;
    @Temporal(TemporalType.DATE)
    private Date expire_date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCC() {
        return CC;
    }

    public void setCC(int CC) {
        this.CC = CC;
    }

    public Date getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(Date expire_date) {
        this.expire_date = expire_date;
    }

    public Customer getAccount() {
        return customer;
    }

    public void setAccount(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", account=" + customer +
                ", holderName='" + holderName + '\'' +
                ", number='" + number + '\'' +
                ", CC=" + CC +
                ", expire_date=" + expire_date +
                '}';
    }
}
