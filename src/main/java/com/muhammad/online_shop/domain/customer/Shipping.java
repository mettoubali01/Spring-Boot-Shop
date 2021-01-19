package com.muhammad.online_shop.domain.customer;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String state;
    private String method;
    private int charge;
    @Temporal(TemporalType.DATE)
    private Date shippingDate;

    public long getId() {
        return id;
    }

    public void setId(long id) { this.id = id; }

    public String getState() {
        return state;
    }

    public void setState(String shippingState) {
        this.state = shippingState;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String shippingMethod) {
        this.method = shippingMethod;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int shipCharge) {
        this.charge = shipCharge;
    }

    @Override
    public String toString() {
        return "Shipping{" +
                "id=" + id +
                ", shippingState='" + state + '\'' +
                ", shippingMethod='" + method + '\'' +
                ", shipCharge=" + charge +
                ", shippingDate=" + shippingDate +
                '}';
    }
}
