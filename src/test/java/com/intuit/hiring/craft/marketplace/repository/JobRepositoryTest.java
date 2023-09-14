package com.intuit.hiring.craft.marketplace.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import com.intuit.hiring.craft.marketplace.domain.Job;
import com.intuit.hiring.craft.marketplace.domain.JobStatus;
import com.intuit.hiring.craft.marketplace.domain.User;


@DataJpaTest
@TestPropertySource(properties = "spring.main.lazy-initialization=true") 
public class JobRepositoryTest {
    
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private JobRepository jobRepository;
    
    
    @Test
    public void addNewJobAndFindIt() {
        User user = new User("Test User", "Test Contact Info");
        Job job = new Job("Test Job Title","Test Job Description", "Test job requirements.",user, JobStatus.OPEN, new Date(), new Date());
        entityManager.persist(user);
        entityManager.persist(job);
        entityManager.flush();

        
        Job found = jobRepository.findById(job.getId()).get();

        // then
        assertThat(found.getJobTitle())
          .isEqualTo("Test Job Title");
    }

}



