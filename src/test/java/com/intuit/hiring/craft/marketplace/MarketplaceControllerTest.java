package com.intuit.hiring.craft.marketplace;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.intuit.hiring.craft.marketplace.domain.Job;
import com.intuit.hiring.craft.marketplace.domain.JobStatus;
import com.intuit.hiring.craft.marketplace.domain.User;
import com.intuit.hiring.craft.marketplace.repository.BidRepository;
import com.intuit.hiring.craft.marketplace.repository.JobRepository;
import com.intuit.hiring.craft.marketplace.repository.UserRepository;

@WebMvcTest(MarketplaceController.class)
public class MarketplaceControllerTest {
    
    @Autowired
    private MockMvc mvc;

    @MockBean
    private JobRepository jobRepository;
    
    @MockBean
    private BidRepository bidRepository;
    
    @MockBean
    private UserRepository userRepository;
   
    
    @Test
    public void testGetJobs() throws Exception {

        User user = new User("Test User", "Test User Contact Info");
        
        Job job = new Job("Test Job Title", "Test Job Description", "Test job requirements.", user, JobStatus.OPEN, new Date(), new Date());

        List<Job> allJobs = Arrays.asList(job);

        when(jobRepository.findAll()).thenReturn(allJobs);

        mvc.perform(get("/jobs")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].jobTitle", is("Test Job Title")));
    }

}

