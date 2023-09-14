package com.intuit.hiring.craft.marketplace;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.intuit.hiring.craft.marketplace.domain.Bid;
import com.intuit.hiring.craft.marketplace.domain.Job;
import com.intuit.hiring.craft.marketplace.repository.BidRepository;
import com.intuit.hiring.craft.marketplace.repository.JobRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MarketplaceController {
    
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private BidRepository bidRepository;
    
    Logger logger = LoggerFactory.getLogger(MarketplaceController.class);

    @GetMapping("/helloworld")
    public MarketplaceServiceResponse helloWorld() {
        return new MarketplaceServiceResponse("Hello World");
    }
    
    @GetMapping("/job/{id}")
    public Job getJob(@PathVariable long id) {
        Optional<Job> job = jobRepository.findById(id);
        if (job.isPresent()) {
            return job.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Job not found");
    }
    
    @PostMapping("/jobs")
    public Job newJob(@RequestBody Job newJob) {
      return jobRepository.save(newJob);
    }
    
    @GetMapping("/jobs")
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
    
    @GetMapping("/bids")
    public List<Bid> getAllBids() {
        return bidRepository.findAll();
    }
    
    @GetMapping("/jobs/open")
    public List<Job> getOpenJobs() {
        return jobRepository.findOpenJobs();
    }
    
    @GetMapping("/jobs/withNoBids")
    public List<Job> getJobsWithNoBids() {
        return jobRepository.findJobsWithNoBids();
    }
    
    @GetMapping("/jobs/withExpiryDateBeforeToday")
    public List<Job> getJobsWithExpiryBeforeToday() {
        return jobRepository.findJobsWithExpiryDateLessThan(new Date());
    }
    
    @GetMapping("/bids/max")
    public List<Bid> getAllMaxBids() {
        return bidRepository.findAllMaxBids();
    }
    
    @GetMapping("/bids/min")
    public List<Bid> getAllMinBids() {
        return bidRepository.findAllMinBids();
    }
    
    @GetMapping("/bids/maxForJob/{id}")
    public Bid getMaxBidForJob(@PathVariable long id) {
        try {    
            return bidRepository.findMaxBidForJob(id);
        } catch (Exception e) {
            logger.error("Could not retrieve max bid for job " + id, e);
            return new Bid();
        }
        
    }
    
    @GetMapping("/bids/minForJob/{id}")
    public Bid getMinBidForJob(@PathVariable long id) {
        try {
            return bidRepository.findMinBidForJob(id);
        } catch (Exception e) {
            logger.error("Could not retrieve min bid for job " + id, e);
            return new Bid();
        }
        
    }
    
    @GetMapping("/bids/countForJob/{id}")
    public int getCountOfBidsForJob(@PathVariable long id) {
        Optional<Job> job = jobRepository.findById(id);
        if (job.isPresent()) {
            return bidRepository.getCountOfBidsForJob(job.get());
        }
        return 0;
    }
}
