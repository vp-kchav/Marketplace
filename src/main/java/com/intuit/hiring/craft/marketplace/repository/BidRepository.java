package com.intuit.hiring.craft.marketplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.intuit.hiring.craft.marketplace.domain.Bid;
import com.intuit.hiring.craft.marketplace.domain.Job;

public interface BidRepository extends JpaRepository<Bid, Long> {
    
    @Query(value = "select * from bid where id in (select b1.id from bid b1 group by b1.job_id, b1.bid_amount, b1.id having b1.bid_amount = (select max(bid_amount) from bid b2 where b1.job_id = b2.job_id))",
            nativeQuery = true)
    public List<Bid> findAllMaxBids();
    
    @Query(value = "select * from bid where id in (select b1.id from bid b1 group by b1.job_id, b1.bid_amount, b1.id having b1.bid_amount = (select min(bid_amount) from bid b2 where b1.job_id = b2.job_id))",
            nativeQuery = true)
    public List<Bid> findAllMinBids();
    
    @Query(value = "select * from bid b0 where id in (select b1.id from bid b1 group by b1.job_id, b1.bid_amount, b1.id having b1.bid_amount = (select max(bid_amount) from bid b2 where b1.job_id = b2.job_id)) and b0.job_id = :jobid",
            nativeQuery = true)
    public Bid findMaxBidForJob(@Param("jobid")long jobid);
    
    @Query(value = "select * from bid b0 where id in (select b1.id from bid b1 group by b1.job_id, b1.bid_amount, b1.id having b1.bid_amount = (select min(bid_amount) from bid b2 where b1.job_id = b2.job_id)) and b0.job_id = :jobid",
            nativeQuery = true)
    public Bid findMinBidForJob(@Param("jobid")long jobid);
    
    @Query(value = "select count(b) from Bid b where b.job = :Job")
    public int getCountOfBidsForJob(@Param("Job")Job job);

}
