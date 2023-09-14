package com.intuit.hiring.craft.marketplace.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.intuit.hiring.craft.marketplace.domain.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
    
    @Query(value = "select j from Job j where j.jobStatus = com.intuit.hiring.craft.marketplace.domain.JobStatus.OPEN")
    List<Job> findOpenJobs();
    
    @Query(value = "select j from Job j where j.jobStatus = com.intuit.hiring.craft.marketplace.domain.JobStatus.EXPIRED")
    List<Job> findExpiredJobs();
    
    @Query(value = "select j from Job j where j.jobStatus = com.intuit.hiring.craft.marketplace.domain.JobStatus.CLOSED")
    List<Job> findClosedJobs();
    
    @Query(value = "select * from job where id not in (select job_id from bid)", 
            nativeQuery = true)
    List<Job> findJobsWithNoBids();
    
    @Query(value="select j from Job j where j.expiryDate < :dateParam")
    List<Job> findJobsWithExpiryDateLessThan(@Param("dateParam")Date dateParam);

}
