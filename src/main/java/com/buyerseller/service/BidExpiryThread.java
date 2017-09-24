package com.buyerseller.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BidExpiryThread
{
    
    @Autowired
    private BidCalculatorInterface bidCalculatorInterface;
    
    
    @Autowired
    private BuyerSellerService buyerSellerService;
    
    
    private ExecutorService executor = Executors.newSingleThreadExecutor();
    public final static Logger logger = LoggerFactory.getLogger(BidExpiryThread.class);

    
    
    private Runnable expiryThread = () -> {
        
        try{
        
            bidCalculatorInterface.getProjectTimestampMap().forEach( (projectId,timestamp) -> {
 	   if(System.currentTimeMillis() > timestamp.getTime()){
 	      bidCalculatorInterface.getProjectTimestampMap().remove(projectId);
 	     buyerSellerService.saveProjectBids(projectId);
 	    bidCalculatorInterface.expireProject(projectId);
           }
        }
        );
        TimeUnit.MILLISECONDS.sleep(500);
        
        }catch(InterruptedException ie){
 	   logger.error("ExpiryThread inteerrupted",ie);
        }

    };
    
    
    @PostConstruct
    void init(){
        executor.submit(expiryThread);
    }
    
    @PreDestroy
    void cleanup(){
        executor.shutdown();
        
    }


}
