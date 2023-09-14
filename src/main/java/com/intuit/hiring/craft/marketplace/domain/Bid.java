package com.intuit.hiring.craft.marketplace.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bid")
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Job job;
    
    @ManyToOne
    private User biddingUser;
    
    @Column(name = "bidAmount", nullable=false)
    private BigDecimal bidAmount;
    
    public Bid() {
        
    }
    
    public Bid(Job job, User biddingUser, BigDecimal bidAmount) {
        this.job = job;
        this.biddingUser = biddingUser;
        this.bidAmount = bidAmount;
    }


    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public User getBiddingUser() {
        return biddingUser;
    }

    public void setBiddingUser(User biddingUser) {
        this.biddingUser = biddingUser;
    }

    public BigDecimal getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(BigDecimal bidAmount) {
        this.bidAmount = bidAmount;
    }

}
