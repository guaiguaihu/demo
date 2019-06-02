package com.example.demo.dao;

import com.example.demo.domain.BusDomain;
import com.example.demo.domain.CostDomain;
import com.example.demo.entity.Bus;
import com.example.demo.entity.Cost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ICostDAO {
    int insert(Cost record);

    Cost selectByPrimaryKey(Integer costId);

    int updateByPrimaryKey(Cost record);

    int delete(Cost cost);

    Integer getListCostCount(@Param("cost") CostDomain costDomain, @Param("page") int page, @Param("limit") int limit);

    List<Cost> listCost(@Param("cost") CostDomain costDomain, @Param("page") int page, @Param("limit") int limit);

    Cost getCost(@Param("costId") Integer costId);
}