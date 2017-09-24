package com.buyerseller.service;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyerseller.common.EntityModelConverter;
import com.buyerseller.exception.BidExpiredException;
import com.buyerseller.exception.InvalidUserException;
import com.buyerseller.exception.ServiceException;
import com.buyerseller.persistence.entity.Bid;
import com.buyerseller.persistence.entity.Project;
import com.buyerseller.persistence.repo.BidRepository;
import com.buyerseller.persistence.repo.ProjectRepository;
import com.buyerseller.persistence.repo.UserRepository;
import com.buyerseller.rest.api.model.BidModel;
import com.buyerseller.rest.api.model.ProjectModel;

@Service
public class BuyerSellerService
{

    @Autowired
    private EntityModelConverter   entityModelConverter;

    @Autowired
    private ProjectRepository      projectRepository;

    @Autowired
    private BidRepository          bidRepository;

    @Autowired
    private UserRepository         userRepository;

    @Autowired
    private BidCalculatorInterface bidCalculator;
    
    public final static Logger logger = LoggerFactory.getLogger(BuyerSellerService.class);

    public Long addProject(ProjectModel projectModel, Long userId)
            throws ServiceException, InvalidUserException
    {

        if ( !userRepository.exists(userId) ) throw new InvalidUserException(String.valueOf(userId));
        
        projectModel.setSellerId(userId);

        Project project = entityModelConverter.projectModelToEntity(projectModel);

        try
        {

            project = projectRepository.save(project);
            bidCalculator.addProject(projectModel);

        }
        catch (Exception exception)
        {
            logger.error(" Add Project failed ",exception);
            throw new ServiceException(exception.getMessage());
        }

        return project.getProjectId();

    }

    public List<ProjectModel> getProjectList(int limit)
            throws ServiceException
    {
	List<Project> list = new ArrayList<Project>();

        try
        {

            projectRepository.findAll().forEach(a -> list.add(a));
            if(limit > 0) return entityModelConverter.projectEntityToModelList(list.subList(0, limit));
            return entityModelConverter.projectEntityToModelList(list);

        }
        catch (Exception exception)
        {
            logger.error(" Get Project List failed ", exception);
            throw new ServiceException(exception.getMessage());
        }

    }

    public ProjectModel getProjectDetails(Long projectId)
            throws ServiceException
    {
        try
        {

            Project project = projectRepository.findOne(projectId);
            return entityModelConverter.projectEntityToModel(project);

        }
        catch (Exception exception)
        {
            logger.error(" GetProjectDetails failed ", exception);
            throw new ServiceException(exception.getMessage());
        }
    }

    public Long deleteProject(String projectId)
            throws ServiceException
    {

        throw new ServiceException("Not Implemented");

    }

    public void bidForProject(Long projectId, BidModel bidModel, Long bidUserId)
            throws ServiceException , BidExpiredException
    {
	
	bidModel.setBidUserId(bidUserId);
	bidModel.setProjectId(projectId);
	
	try{
	    bidCalculator.addBid(projectId, bidModel);
	    
	}catch(Exception exception){
	    logger.error(" bidForProject failed ", exception);
            throw new ServiceException(exception.getMessage());
	    
	}
	
	
    }

    public List<BidModel> getBidList(Long projectId)
            throws ServiceException
    {

        try
        {
           List<Bid> list = bidRepository.findByProjectId(projectId);
            return entityModelConverter.bidEntityToModelList(list);
        }
        catch (Exception exception)
        {
            logger.error(" getBidList failed ", exception);
            throw new ServiceException(exception.getMessage());

        }

    }
    
    public void saveProjectBids(Long projectId)
            throws ServiceException
    {
        try
        {

            Project project = projectRepository.findOne(projectId);
            SortedSet<BidModel> set = bidCalculator.getTopThreeBids(project.getProjectId());

            Object[] array = set.toArray();
            int rank = 0;
            for (Object obj : array)
            {

                BidModel bidData = (BidModel) obj;
                bidData.setProjectId(projectId);
                Bid bid = entityModelConverter.bidModelToEntity(bidData);
                bid.setRank(rank++);
                bid.setProjectId(projectId);
                bidRepository.save(bid);
            }

        }
        catch (Exception exception)
        {
            logger.error(" GetProjectDetails failed ", exception);
            throw new ServiceException(exception.getMessage());
        }}
}
