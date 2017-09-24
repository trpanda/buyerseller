package com.buyerseller.persistence.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "bid")
public class Bid
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bid_id")
    private Long    bidId;
    @Column(name = "bid_name")
    private String    bidName;
    @Column(name = "bid_value")
    private BigDecimal    value;
    @Column(name = "bid_rank")
    private Integer    rank;
    @Column(name = "bid_project_id")
    private Long    projectId;
    @Column(name = "bid_user_id")
    private Long    userId;
    public Long getBidId()
    {
        return bidId;
    }
    public void setBidId(Long bidId)
    {
        this.bidId = bidId;
    }
    public String getBidName()
    {
        return bidName;
    }
    public void setBidName(String bidName)
    {
        this.bidName = bidName;
    }
    public BigDecimal getValue()
    {
        return value;
    }
    public void setValue(BigDecimal value)
    {
        this.value = value;
    }
    public Integer getRank()
    {
        return rank;
    }
    public void setRank(Integer rank)
    {
        this.rank = rank;
    }
    public Long getProjectId()
    {
        return projectId;
    }
    public void setProjectId(Long projectId)
    {
        this.projectId = projectId;
    }
    public Long getUserId()
    {
        return userId;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }
  
}
