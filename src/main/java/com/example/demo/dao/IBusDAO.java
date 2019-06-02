package com.example.demo.dao;

import com.example.demo.domain.BusDomain;
import com.example.demo.entity.Bus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IBusDAO {
    int insert(Bus bus);
    int update(Bus bus);
    int delete(Bus bus);
    Integer getListBusCount(@Param("bus") BusDomain busDomain, @Param("page") int page, @Param("limit") int limit);
    List<Bus> listBus(@Param("bus") BusDomain busDomain, @Param("page") int page, @Param("limit") int limit);
    Bus getBus(@Param("busId") Long busId);
}