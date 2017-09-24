package com.buyerseller.service;

import java.sql.Timestamp;
import java.util.Map;
import java.util.SortedSet;

import com.buyerseller.exception.BidExpiredException;
import com.buyerseller.exception.ServiceException;
import com.buyerseller.rest.api.model.BidModel;
import com.buyerseller.rest.api.model.ProjectModel;

public interface BidCalculatorInterface
{

    public void addProject(ProjectModel projectModel) throws ServiceException;

    public void addBid(Long projectId, BidModel current) throws BidExpiredException ,ServiceException;

    public SortedSet<BidModel> getTopThreeBids(Long projectId)throws ServiceException;

    public Timestamp getExpiryTime(Long projectId) throws ServiceException;

    public void changeExpiryTime(Long projectId, Timestamp expiryTime) throws ServiceException;
    
    public  Map<Long, Timestamp> getProjectTimestampMap();
    
    public void expireProject(Long projectId) throws ServiceException;
    
    

}
