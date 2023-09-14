package com.intuit.hiring.craft.marketplace.repository;

import java.util.Date;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.intuit.hiring.craft.marketplace.domain.Bid;
import com.intuit.hiring.craft.marketplace.domain.Job;
import com.intuit.hiring.craft.marketplace.domain.JobStatus;
import com.intuit.hiring.craft.marketplace.domain.User;

@Component
public class DatabaseInitializer {
    private JobRepository jobRepository;
    private UserRepository userRepository;
    private BidRepository bidRepository;
    private Random randomNumberGenerator;
    private List<BigDecimal> possibleBids = new ArrayList<>();

    @Autowired
    public DatabaseInitializer(JobRepository jobRepository, UserRepository userRepository, BidRepository bidRepository) {
        this.jobRepository = jobRepository;
        this.userRepository = userRepository;
        this.bidRepository = bidRepository;
        randomNumberGenerator = new Random();
        initializePossibleBids();
        initializeTestData();
    }

    private void initializeTestData() {
        List<User> users = getUsers();
        for(User user: users) {
            userRepository.save(user);
        }
        
        List<Job> jobs = getListOfJobs(users);
        for(Job job: jobs) {
            jobRepository.save(job);
        }
        
        List<Bid> bids = getListOfBids(jobs,users);
        for(Bid bid: bids) {
            bidRepository.save(bid);
        }
        

        System.out.println("Successfully initliazed the database.");
    }
    


    private List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Michael Scott", getRandomPhoneNumber()));
        users.add(new User("Ryan Howard", getRandomPhoneNumber()));
        users.add(new User("Dwight Schrute", getRandomPhoneNumber()));
        users.add(new User("Stanley Hudson", getRandomPhoneNumber()));
        users.add(new User("Kevin Malone", getRandomPhoneNumber()));
        users.add(new User("Jim Halpert", getRandomPhoneNumber()));
        users.add(new User("Meredith Palmer", getRandomPhoneNumber()));
        users.add(new User("Pam Beesly", getRandomPhoneNumber()));
        users.add(new User("Angela Martin", getRandomPhoneNumber()));      
        users.add(new User("Clark Green", getRandomPhoneNumber()));
        users.add(new User("Nellie Bertram", getRandomPhoneNumber()));
        users.add(new User("Oscar Martinez", getRandomPhoneNumber()));
        users.add(new User("Phyllis Vance", getRandomPhoneNumber()));
        users.add(new User("Kelly Kapoor", getRandomPhoneNumber()));
        users.add(new User("Roy Anderson", getRandomPhoneNumber()));
        users.add(new User("Toby Flenderson", getRandomPhoneNumber()));
        users.add(new User("Andy Bernard", getRandomPhoneNumber()));
        users.add(new User("Creed Bratton", getRandomPhoneNumber()));
        users.add(new User("Darryl Philbin", getRandomPhoneNumber()));
        users.add(new User("Erin Hannon ", getRandomPhoneNumber()));
        users.add(new User("Gabe Lewis", getRandomPhoneNumber()));
        users.add(new User("Jan Levinson", getRandomPhoneNumber()));
        users.add(new User("Holly Flax", getRandomPhoneNumber()));
        users.add(new User("Robert California", getRandomPhoneNumber()));
        return users;

    }
    
 
    private String getRandomPhoneNumber() {
        String areaCode = String.valueOf(randomNumberGenerator.nextInt(899) + 100);
        String prefix = String.valueOf(randomNumberGenerator.nextInt(899) + 100);
        String suffix = String.valueOf(randomNumberGenerator.nextInt(8999) + 1000);
        return areaCode + "-" + prefix + "-" + suffix;
    }
    
    private List<Job> getListOfJobs(List<User> users) {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Fence Required","I need a fence built", "The fence dimensions are 10x10x15 yards and it needs to keep my dog from escaping.",getRandomUser(users), JobStatus.OPEN, getRandomPostingDate(), getRandomExpiryDate()));
        jobs.add(new Job("Install Lights","Require lighting in my dining room", "Four pot lights ceiling installation required.",getRandomUser(users), JobStatus.OPEN, getRandomPostingDate(), getRandomExpiryDate()));
        jobs.add(new Job("Paint House","Paint the exterior of my house", "I need the exterior of my house painted. Material is a mix of siding and stucco.",getRandomUser(users), JobStatus.OPEN, getRandomPostingDate(), getRandomExpiryDate()));
        jobs.add(new Job("Hot Tub","Install hot tub in deck", "I require someone to install whirlpool 600x hot tub in my deck, including all plubming and electrical.",getRandomUser(users), JobStatus.OPEN, getRandomPostingDate(), getRandomExpiryDate()));
        jobs.add(new Job("Electrical Panel","New Electrical Panel", "I got a Tesla. Yay! I need more power. Boo! Need someone to install a new electrical panel with appropriate capacity to charge my Tesla.",getRandomUser(users), JobStatus.OPEN, getRandomPostingDate(), getRandomExpiryDate()));
        jobs.add(new Job("Mouse Problem","I have mouse infestation in my shed", "I am allergic to cats and need some way to get rid of the mice in my shed.",getRandomUser(users), JobStatus.OPEN, getRandomPostingDate(), getRandomExpiryDate()));
        jobs.add(new Job("Door Installation","Install Exterior Doors", "Install both front and back doors, doors supplied but bring your own tools.",getRandomUser(users), JobStatus.OPEN, getRandomPostingDate(), getRandomExpiryDate()));
        jobs.add(new Job("I hate IKEA","Put together IKEA furniture", "I bought both the flugl and dromper and have no idea how to put these together, please can anyone help.",getRandomUser(users), JobStatus.OPEN, getRandomPostingDate(), getRandomExpiryDate()));
        jobs.add(new Job("Washer/Dryer","Washer Dryer Basement Install", "Bought new washer/dryer from Home Depot and need them installed in my basement.",getRandomUser(users), JobStatus.OPEN, getRandomPostingDate(), getRandomExpiryDate()));
        jobs.add(new Job("Landscaping","New lot requires landscaping", "Nothing but bare dirt so I'd like at least 5 trees, sod, a gardening area and some accents too please.",getRandomUser(users), JobStatus.OPEN, getRandomPostingDate(), getRandomExpiryDate()));
        jobs.add(new Job("Babyproofing","Need my house safe for new arrival!", "I am expecting in the next three months and need someone to install gates, install electrical socket protectors and remove any other hazards.",getRandomUser(users), JobStatus.OPEN, getRandomPostingDate(), getRandomExpiryDate()));
        jobs.add(new Job("Plumber needed","Leaky Faucet", "I have a leaky faucet and require a plumber to help me fix. Both bathrooms please.",getRandomUser(users), JobStatus.OPEN, getRandomPostingDate(), getRandomPostingDate()));
        jobs.add(new Job("Interior Paint","5 Interior Rooms To Paint", "Need somebody to paint guest room, master bathroom, master bedroom, kitchen, living room with paint color #456x95s interior eggshell from Master Paints.",getRandomUser(users), JobStatus.OPEN, getRandomPostingDate(), getRandomExpiryDate()));
        jobs.add(new Job("House Wash","Exterior House Wash", "Require someone to wash the exterior of my house including all windows, garage door and siding.",getRandomUser(users), JobStatus.CLOSED, getRandomPostingDate(), getRandomExpiryDate()));
        jobs.add(new Job("TV Setup","Smart TV makes me feel dumb", "Got a brand spanking new TV and unfortunately cannot figure out for the life of me how to watch anything, just getting static. Please help! It is a Panasonic HG4350.",getRandomUser(users), JobStatus.OPEN, getRandomPostingDate(), getRandomExpiryDate()));
        jobs.add(new Job("Want to Sing","Singing Teacher Required", "I have huge natural singing talent but require someone to help me reach the next American Idol. I am thinking lessons twice a week.",getRandomUser(users), JobStatus.OPEN, getRandomPostingDate(), getRandomExpiryDate()));
        jobs.add(new Job("Demolition","Shed Demolition", "I have a shed in my backyard that is falling apart and I don't want it anymore. Bid should include price for demolishing it and hauling it away. 10x10 feet approx.",getRandomUser(users), JobStatus.OPEN, getRandomPostingDate(), getRandomExpiryDate()));
        jobs.add(new Job("Website/App","New Facebook Killer", "I have an amazing idea for the next killer website/app that is going to take over from facebook. Need a programmer to help me write it. Serious bids only.",getRandomUser(users), JobStatus.CLOSED, getRandomPostingDate(), getRandomExpiryDate()));
        jobs.add(new Job("Lawn Care","Mowing, Seeding, Aerating", "Require someone to mow my lawn weekly, aerate and mow once every season.",getRandomUser(users), JobStatus.OPEN, getRandomPostingDate(), getRandomExpiryDate()));
        jobs.add(new Job("Unit Test","Unit Test Failures", "Help! All my unit tests are failing and I can't figure out what the issue is. It rand out of threads??? Huh?",getRandomUser(users), JobStatus.OPEN, getRandomPostingDate(), getRandomExpiryDate()));
        jobs.add(new Job("New Driveway","My old driveway is busted", "Remove my old driveway and pour me a new driveway. The driveway size is 20x20 feet.",getRandomUser(users), JobStatus.OPEN, getRandomPostingDate(), getRandomExpiryDate()));
        jobs.add(new Job("Air Conditioner Install","Air conditioner window installation", "It is so hot here! I need an air conditioner stat! One that fits in the window.",getRandomUser(users), JobStatus.OPEN, getRandomPostingDate(), getRandomExpiryDate()));
        jobs.add(new Job("Drive My Car","Drive my car from Sacramento to Seattle", "Took a business trip to Sacramento and flew back home to Seattle. Looking for someone to drive it back for me.",getRandomUser(users), JobStatus.OPEN, getRandomPostingDate(), getRandomExpiryDate()));
        jobs.add(new Job("New Shower","New Shower Installation", "Looking for old shower removal, installation of new shower.",getRandomUser(users), JobStatus.OPEN, getRandomPostingDate(), getRandomExpiryDate()));
        jobs.add(new Job("Window Install","12 New Windows Install", "Looking for someone to install 12 double-paned tinted windows in my house.",getRandomUser(users), JobStatus.CLOSED, getRandomPostingDate(), getRandomExpiryDate()));
        jobs.add(new Job("Oil Change","Charger 1967 Oil Change", "Looking for someone who knows how to change the oil in my 1967 Dodge Charger.",getRandomUser(users), JobStatus.CLOSED, getRandomPostingDate(), getRandomExpiryDate()));
        jobs.add(new Job("Hockey Stick Bench","Build a bench from my old hockey sticks", "I have 32 old wooden hockey sticks from my playing days and I'd like them turned into a nice bench.",getRandomUser(users), JobStatus.OPEN, getRandomPostingDate(), getRandomPostingDate()));
        jobs.add(new Job("Junk Removal","Have 40 Boxes of junk", "I have 40 boxes of comic books, mad magazines and random assorted junk to be disposed of at the dump. Looking for someone to haul it away.",getRandomUser(users), JobStatus.OPEN, getRandomPostingDate(), getRandomExpiryDate()));
        jobs.add(new Job("Swingset Construction","Help Me Build A Swingset I bought", "I bought a swingset from Wal-Mart for my two children and need someone to install it in my backyard.",getRandomUser(users), JobStatus.OPEN, getRandomPostingDate(), getRandomExpiryDate()));
        jobs.add(new Job("Carpet Cleaning","Pets Ruining My Carpet - Need it Cleaned", "My four cats and two dogs have stained my carpet. Looking for professional-grade carpet cleaner to assess the damage and possibly clean.",getRandomUser(users), JobStatus.OPEN, getRandomPostingDate(), getRandomExpiryDate()));
        jobs.add(new Job("Test Please Ignore","TESTING PLEASE IGNORE", "Oh shoot, I don't know how this darn website works, goshdarn",getRandomUser(users), JobStatus.EXPIRED, getRandomPostingDate(), getRandomPostingDate()));
        
        return jobs;
    }

    private List<Bid> getListOfBids(List<Job> jobs, List<User> users) {
        List<Bid> bids = new ArrayList<>();
        int jobToLeaveWithNoBids = randomNumberGenerator.nextInt(jobs.size());
        int j = 0;
       
        
        for (Job job: jobs) {
            List<BigDecimal> bidAmounts = new ArrayList<>();
            List<User> usersThatShouldBeExcludedFromBidding = new ArrayList<>();
            j++;
            if (jobToLeaveWithNoBids == j) {
                continue;
            }
            usersThatShouldBeExcludedFromBidding.add(job.getPostingUser());
            int numberOfBids = randomNumberGenerator.nextInt(4);
            for (int i =0; i <= numberOfBids; i++) {
                User biddingUser = getRandomUserButNotTheseUsers(users, usersThatShouldBeExcludedFromBidding);
                BigDecimal bidAmount = getRandomBidAmountButNotIncludingTheseAmounts(bidAmounts);
                bids.add(new Bid(job, biddingUser, bidAmount));
                bidAmounts.add(bidAmount);
                usersThatShouldBeExcludedFromBidding.add(biddingUser);
            }
        }
        
        return bids;
    }
    
    private BigDecimal getRandomBidAmountButNotIncludingTheseAmounts(List<BigDecimal> bidsAlreadyMade) {
        
        int sanityCounter = 0; 
        BigDecimal returnBid = possibleBids.get(randomNumberGenerator.nextInt(possibleBids.size()));
        
        while (bidsAlreadyMade.contains(returnBid)) {
            sanityCounter++;
            if (sanityCounter > (1000 * bidsAlreadyMade.size())) {
                throw new RuntimeException("Something is wrong with trying to get a random bid amount. Breaking out of the loop.");
            }
            returnBid = possibleBids.get(randomNumberGenerator.nextInt(possibleBids.size()));
        }
        return returnBid;
    }
    

    private void initializePossibleBids() {
        possibleBids.add(new BigDecimal(1.0));
        possibleBids.add(new BigDecimal(5.0));
        possibleBids.add(new BigDecimal(10.0));
        possibleBids.add(new BigDecimal(20.0));
        possibleBids.add(new BigDecimal(50.0));
        possibleBids.add(new BigDecimal(75.0));
        possibleBids.add(new BigDecimal(100.0));
        possibleBids.add(new BigDecimal(125.0));
        possibleBids.add(new BigDecimal(150.0));
        possibleBids.add(new BigDecimal(200.0));
        possibleBids.add(new BigDecimal(500.0));
        possibleBids.add(new BigDecimal(1000.0));
        possibleBids.add(new BigDecimal(750.0));
        possibleBids.add(new BigDecimal(2000.0));
        possibleBids.add(new BigDecimal(5000.0));
        possibleBids.add(new BigDecimal(6000.0));
        possibleBids.add(new BigDecimal(7000.0));
    }

    private User getRandomUser(List<User> users) {
       return getRandomUserButNotTheseUsers(users, new ArrayList<>());
    }

    private User getRandomUserButNotTheseUsers(List<User> users, List<User> usersThatShouldBeExcluded) {
        int sanityCounter = 0; 
        User returnUser = users.get(randomNumberGenerator.nextInt(users.size()));
        
        while (usersThatShouldBeExcluded.contains(returnUser)) {
            sanityCounter++;
            if (sanityCounter > (1000 * users.size())) {
                throw new RuntimeException("Something is wrong with trying to get a random user. Breaking out of the loop.");
            }
            returnUser = users.get(randomNumberGenerator.nextInt(users.size()));
        }
        return returnUser;
    }
    
    
    private Date getRandomExpiryDate() {
        Instant xFromNow = Instant.now().plus(Duration.ofDays(randomNumberGenerator.nextInt(31)));
        return Date.from(xFromNow);
    }

    private Date getRandomPostingDate() {
        Instant xDaysAgo = Instant.now().minus(Duration.ofDays(randomNumberGenerator.nextInt(31)));
        return Date.from(xDaysAgo);
    }
}



