package com.buyerseller.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.buyerseller.persistence.entity.Bid;
import com.buyerseller.persistence.entity.Project;
import com.buyerseller.rest.api.model.BidModel;
import com.buyerseller.rest.api.model.ProjectModel;

@Component
public class EntityModelConverter
{
    
    
    public Project  projectModelToEntity(ProjectModel model){
	
	Project project  = new Project();
	
	project.setCreatedBy(model.getSellerId());
	project.setExpire(model.getExpiryDateTime());
	
	if(model.getProjectId() !=null && model.getProjectId() > 0)
	    project.setProjectId(model.getProjectId());
	
	project.setProjectName(model.getProjectName());
	return project;
    }
    
    public ProjectModel  projectEntityToModel(Project entity){
	
	ProjectModel projectModel = new ProjectModel();
	projectModel.setExpiryDateTime(entity.getExpire());
	projectModel.setProjectId(entity.getProjectId());
	projectModel.setProjectName(entity.getProjectName());
	projectModel.setSellerId(entity.getCreatedBy());
	return projectModel;
    }
    
    
    public List<ProjectModel>  projectEntityToModelList(List<Project> entity){
	
	List<ProjectModel>  list = new ArrayList<ProjectModel>();
	
	entity.stream().forEachOrdered(p -> list.add(projectEntityToModel(p)));
	
	return list;
    }
    
    public Bid  bidModelToEntity(BidModel model){
	
	Bid bid = new Bid();
	if(model.getBidId()!=null && model.getBidId() > 0){
	 bid.setBidId(model.getBidId());   
	}
	if(model.getProjectId()!=null && model.getProjectId() > 0)
	    bid.setProjectId(model.getProjectId());
	bid.setRank(model.getRank());
	bid.setUserId(model.getBidUserId());
	bid.setValue(model.getBidValue());
	return bid;
    }
    
    public BidModel  bidEntityToModel(Bid entity){
	BidModel model = new BidModel();
	model.setBidId(entity.getBidId());
	model.setBidUserId(entity.getUserId());
	model.setBidValue(entity.getValue());
	model.setProjectId(entity.getProjectId());
	model.setRank(entity.getRank());
	return model;
    }
    
    
    public List<BidModel>  bidEntityToModelList(List<Bid> entity){
	
	List<BidModel>  list = new ArrayList<BidModel>();
	
	entity.stream().forEachOrdered(p -> list.add(bidEntityToModel(p)));
	
	return list;
    }



}
