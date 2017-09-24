package com.buyerseller.persistence.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity

@Table(name = "project")
public class Project
{
    @Id
    @Column(name = "project_id")
    private Long    projectId;
    @Column(name = "project_name")
    private String    projectName;
    @Column(name = "project_expire")
    private Timestamp    expire;
    @Column(name = "project_createdby")
    private Long    createdBy;
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
    public Timestamp getExpire()
    {
        return expire;
    }
    public void setExpire(Timestamp expire)
    {
        this.expire = expire;
    }
    public Long getCreatedBy()
    {
        return createdBy;
    }
    public void setCreatedBy(Long createdBy)
    {
        this.createdBy = createdBy;
    }
  
}
