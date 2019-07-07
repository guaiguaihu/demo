package com.example.demo.mapper;

import com.example.demo.domain.OrderBusDomain;
import com.example.demo.entity.OrderBus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderBusDAO {
    int insert(OrderBus record);

    OrderBus selectByPrimaryKey(Integer ordBusId);

    int updateByPrimaryKey(OrderBus record);

    List<OrderBus> listByOrdId(@Param("ordId") Integer ordId);

    void deleteByOrdId(@Param("ordId") Integer ordId);
}