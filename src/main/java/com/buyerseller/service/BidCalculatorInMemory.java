package com.buyerseller.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.buyerseller.exception.BidExpiredException;
import com.buyerseller.rest.api.model.BidModel;
import com.buyerseller.rest.api.model.ProjectModel;

@Component
public class BidCalculatorInMemory implements BidCalculatorInterface {

	private static Map<Long, Timestamp> projectTimestampMap = new ConcurrentHashMap<Long, Timestamp>();
	private static Map<Long, SortedSet<BidModel>> projectBidMap = new ConcurrentHashMap<Long, SortedSet<BidModel>>();
	public final static Logger logger = LoggerFactory.getLogger(BidCalculatorInMemory.class);

	public Comparator<BidModel> bidComparator=new Comparator<BidModel>(){

	@Override public int compare(BidModel m1,BidModel m2){return m2.getBidValue().compareTo(m1.getBidValue());}};

	@Override
	public void addProject(ProjectModel projectModel) {
		projectTimestampMap.put(projectModel.getProjectId(), projectModel.getExpiryDateTime());

	}

	@Override
	public void addBid(Long projectId, BidModel current) throws BidExpiredException {

		Timestamp expiryTime = projectTimestampMap.get(projectId);
		long now = System.currentTimeMillis();

		if (expiryTime == null || now > expiryTime.getTime())
			throw new BidExpiredException();
		SortedSet<BidModel> top3 = new TreeSet<BidModel>(bidComparator);
		top3 = projectBidMap.getOrDefault(projectId, top3);

		// if ( top3 == null ) throw new BidExpiredException();
		BigDecimal smallestOfTheTop3 = null;

		if (smallestOfTheTop3 == null || current.getBidValue().compareTo(smallestOfTheTop3) > 0) {
			top3.add(current);
			if (top3.size() > 3) {
				BidModel last = top3.last();
				smallestOfTheTop3 = last.getBidValue();
				top3.remove(last);
			}
		}
		
		projectBidMap.put(projectId, top3);
	

	}

	@Override
	public SortedSet<BidModel> getTopThreeBids(Long projectId) {
		return projectBidMap.getOrDefault(projectId, new TreeSet<BidModel>(bidComparator));

	}

	@Override
	public Timestamp getExpiryTime(Long projectId) {
		return projectTimestampMap.get(projectId);
	}

	@Override
	public void changeExpiryTime(Long projectId, Timestamp expiryTime) {
		projectTimestampMap.put(projectId, expiryTime);
	}

	@Override
	public Map<Long, Timestamp> getProjectTimestampMap() {
		return projectTimestampMap;
	}

	@Override
	public String toString() {
		Iterator<Long> iter = projectBidMap.keySet().iterator();
		String ret = "";
		while (iter.hasNext()) {
			Long projectId = iter.next();
			SortedSet<BidModel> bidSet = projectBidMap.get(projectId);
			Object[] arr = bidSet.toArray();
			ret = ret + "projectId :=" + projectId + "[";
			for (Object bdObj : arr) {
				BidModel bd = (BidModel) bdObj;
				ret = ret + bd.getBidUserId() + "->" + bd.getBidValue() + ",";
			}
			ret = ret + "]   ;   ";
		}
		return ret;
	}

	@Override
	public void expireProject(Long projectId) {
		projectBidMap.remove(projectId);

	}
}
