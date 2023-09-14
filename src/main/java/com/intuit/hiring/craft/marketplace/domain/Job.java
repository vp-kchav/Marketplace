package com.intuit.hiring.craft.marketplace.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "jobTitle", nullable=false)
    private String jobTitle;

    @Column(name = "jobDescription")
    private String jobDescription;
    
    @Column(name = "jobRequirements")
    private String jobRequirements;
    
    @ManyToOne
    private User postingUser;
    
    @Column(name = "jobStatus", nullable=false)
    private JobStatus jobStatus;
    
    @Column(name = "jobPostedDate", nullable=false)
    private Date jobPostedDate;
    
    @Column(name = "expiryDate", nullable=false)
    private Date expiryDate;
    
    public Job() {
        
    }
    
    public Job(String jobTitle, String jobDescription, String jobRequirements, User postingUser, JobStatus jobStatus,
            Date jobPostedDate, Date expiryDate) {
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.jobRequirements = jobRequirements;
        this.postingUser = postingUser;
        this.jobStatus = jobStatus;
        this.jobPostedDate = jobPostedDate;
        this.expiryDate = expiryDate;
    }

    public long getId() {
        return id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobRequirements() {
        return jobRequirements;
    }

    public void setJobRequirements(String jobRequirements) {
        this.jobRequirements = jobRequirements;
    }

    public User getPostingUser() {
        return postingUser;
    }

    public void setPostingUser(User postingUser) {
        this.postingUser = postingUser;
    }

    public JobStatus getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(JobStatus jobStatus) {
        this.jobStatus = jobStatus;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
