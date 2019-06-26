package com.example.demo.mapper;

import com.example.demo.domain.OrderDomain;
import com.example.demo.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface OrderDAO {
    int insert(Order record);

    Order selectByPrimaryKey(Integer ordId);

    int updateByPrimaryKey(Order record);

    int delete(@Param("ordId") Integer ordId, @Param("deleteName") String deleteName);

    Integer getListOrderCount(@Param("order") OrderDomain orderDomain, @Param("page") int page, @Param("limit") int limit);

    List<Order> listOrder(@Param("order") OrderDomain orderDomain, @Param("startRecord") int startRecord, @Param("limit") int limit);

    Order getOrder(@Param("ordId") Integer ordId);

    List<Order> listUsingOrder(@Param("busId") Integer busId);
}