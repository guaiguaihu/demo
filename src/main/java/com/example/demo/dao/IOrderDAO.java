package com.example.demo.dao;

import com.example.demo.domain.OrderDomain;
import com.example.demo.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface IOrderDAO {
    int insert(Order record);

    Order selectByPrimaryKey(Integer ordId);

    int updateByPrimaryKey(Order record);

    int delete(Order order);

    Integer getListOrderCount(@Param("order") OrderDomain orderDomain, @Param("page") int page, @Param("limit") int limit);

    List<Order> listOrder(@Param("order") OrderDomain orderDomain, @Param("page") int page, @Param("limit") int limit);

    Order getOrder(@Param("ordId") Integer ordId);
}