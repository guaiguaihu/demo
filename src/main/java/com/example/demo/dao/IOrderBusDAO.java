package com.example.demo.dao;

import com.example.demo.domain.OrderBusDomain;
import com.example.demo.entity.OrderBus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IOrderBusDAO {
    int insert(OrderBus record);

    OrderBus selectByPrimaryKey(Integer ordBusId);

    int updateByPrimaryKey(OrderBus record);

    List<OrderBusDomain> listByOrdId(@Param("ordId") Integer ordId);

    void deleteByOrdId(@Param("ordId") Integer ordId);
}