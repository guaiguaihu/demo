package com.example.demo.service;

import com.example.demo.entity.Bus;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderBus;

import java.util.List;


/**
 * IOrderService
 *
 * @author liujinliang
 * @date 2019/5/31
 **/
public interface IOrderService {
    void saveOrder(Order order, List<OrderBus> busList);
    void editOrder(Order order, List<OrderBus> busList);
    void deleteOrder(Integer ordId);
}
