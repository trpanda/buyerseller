package com.buyerseller.rest.api.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.swagger.annotations.ApiModel;

@ApiModel
public class ProjectModel
{
    
    private Long projectId = 0l;
    private String projectName ;
    private String projectDesc;
    private Timestamp expiryDateTime;
    private boolean isExpired ;
    private List<BidModel> top3Bids = new ArrayList<BidModel>();
    private Long sellerId = 0l;
    public Long getProjectId()
    {
        return projectId;
    }
    public void setProjectId(Long projectId)
    {
        this.projectId = projectId;
    }
    public String getProjectName()
    {
        return projectName;
    }
    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }
    public String getProjectDesc()
    {
        return projectDesc;
    }
    public void setProjectDesc(String projectDesc)
    {
        this.projectDesc = projectDesc;
    }
    public Timestamp getExpiryDateTime()
    {
        return expiryDateTime;
    }
    public void setExpiryDateTime(Timestamp expiryDateTime)
    {
        this.expiryDateTime = expiryDateTime;
    }
    public Long getSellerId()
    {
        return sellerId;
    }
    public void setSellerId(Long buyerId)
    {
        this.sellerId = buyerId;
    }
  
    public boolean isExpired() {
		return isExpired;
	}
	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}

	public List<BidModel> getTop3Bids() {
		return top3Bids;
	}
	public void setTop3Bids(List<BidModel> top3Bids) {
		this.top3Bids = top3Bids;
	}
	@Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((projectId == null) ? 0 : projectId.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj)
    {
        if ( this == obj ) return true;
        if ( obj == null ) return false;
        if ( getClass() != obj.getClass() ) return false;
        ProjectModel other = (ProjectModel) obj;
        if ( projectId == null )
        {
            if ( other.projectId != null ) return false;
        }
        else if ( !projectId.equals(other.projectId) ) return false;
        return true;
    }

}
