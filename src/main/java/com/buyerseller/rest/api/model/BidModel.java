package com.buyerseller.rest.api.model;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;

@ApiModel
public class BidModel
{
    
    private Long bidId = 0l;
    private Long projectId = 0l;
    private String projectName; 
    private String bidderName; 
    private BigDecimal BidValue;
    private Long bidUserId =0l;
    private Integer rank =-1;
    
    
    public Long getBidId()
    {
        return bidId;
    }
    public void setBidId(Long bidId)
    {
        this.bidId = bidId;
    }
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
    public String getBidderName()
    {
        return bidderName;
    }
    public void setBidderName(String bidderName)
    {
        this.bidderName = bidderName;
    }
    public BigDecimal getBidValue()
    {
        return BidValue;
    }
    public void setBidValue(BigDecimal bidValue)
    {
        BidValue = bidValue;
    }
    public Long getBidUserId()
    {
        return bidUserId;
    }
    public void setBidUserId(Long bidUserId)
    {
        this.bidUserId = bidUserId;
    }
    public Integer getRank()
    {
        return rank;
    }
    public void setRank(Integer rank)
    {
        this.rank = rank;
    }
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bidId == null) ? 0 : bidId.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj)
    {
        if ( this == obj ) return true;
        if ( obj == null ) return false;
        if ( getClass() != obj.getClass() ) return false;
        BidModel other = (BidModel) obj;
        if ( bidId == null )
        {
            if ( other.bidId != null ) return false;
        }
        else if ( !bidId.equals(other.bidId) ) return false;
        return true;
    } 

}
