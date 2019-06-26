package com.example.demo.mapper;

import com.example.demo.domain.BusDomain;
import com.example.demo.domain.OrderDomain;
import com.example.demo.entity.Bus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BusDAO {
    int insert(Bus bus);
    int update(Bus bus);
    int delete(Bus bus);
    Integer getListBusCount(@Param("bus") BusDomain busDomain, @Param("page") int page, @Param("limit") int limit);
    List<Bus> listBus(@Param("bus") BusDomain busDomain, @Param("page") int page, @Param("limit") int limit);
    Bus getBus(@Param("busId") Long busId);
}