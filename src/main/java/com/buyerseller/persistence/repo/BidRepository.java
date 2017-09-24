package com.buyerseller.persistence.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buyerseller.persistence.entity.Bid;


@Repository
public interface BidRepository
        extends JpaRepository<Bid, Long>
{

    public List<Bid> findByProjectId(Long projectId);
    // no body required
}
