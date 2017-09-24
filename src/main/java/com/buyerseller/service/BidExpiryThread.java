package com.buyerseller.service;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BidExpiryThread {

	@Autowired
	private BidCalculatorInterface bidCalculatorInterface;

	@Autowired
	private BuyerSellerService buyerSellerService;

	public final static Logger logger = LoggerFactory.getLogger(BidExpiryThread.class);

	@Scheduled(fixedDelay = 500)
	void visitExpireMap() {
		
		logger.trace("##############Expired Scheduler Running:: " +System.currentTimeMillis() );

		try {

			bidCalculatorInterface.getProjectTimestampMap().forEach((projectId, timestamp) -> {
				if (System.currentTimeMillis() > timestamp.getTime()) {
					logger.info("##############Expired Project:: " + projectId);
					bidCalculatorInterface.getProjectTimestampMap().remove(projectId);
					buyerSellerService.saveProjectBids(projectId);
					//bidCalculatorInterface.expireProject(projectId);
				}
			});

		} catch (Exception ie) {
			logger.error("ExpiryThread error", ie);
		}
	}

	@PreDestroy
	void cleanup() {

	}

}
