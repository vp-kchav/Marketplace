package com.intuit.hiring.craft.marketplace.system;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class AutomatedSystemFunctions {
    
    @Scheduled(fixedRateString = "${marketplace.automated.system.function.interval}")
    public void doAutomatedSystemFunctions() {
        System.out.println("Hmmmm, this is an interesting function. I wonder what could happen here?");
    }

}
