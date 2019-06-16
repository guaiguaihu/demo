package com.example.demo.service;

import com.example.demo.dao.IOrderBusDAO;
import com.example.demo.dao.IOrderDAO;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderBus;
import com.example.demo.util.OperatorInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * OrderServiceImpl
 *
 * @author liujinliang
 * @date 2019/5/31
 **/
@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    IOrderDAO orderDAO;

    @Autowired
    IOrderBusDAO orderBusDAO;

    @Override
    public void saveOrder(Order order, List<OrderBus> busList) {
        OperatorInfoUtil.fillOperateInfo(order);
        orderDAO.insert(order);
        for (OrderBus bus : busList) {
            OperatorInfoUtil.fillOperateInfo(bus);
            bus.setOrdId(order.getOrdId());
            orderBusDAO.insert(bus);
        }
    }

    @Override
    public void editOrder(Order order, List<OrderBus> busList) {
        OperatorInfoUtil.fillUpdateInfo(order);
        orderDAO.updateByPrimaryKey(order);
        orderBusDAO.deleteByOrdId(order.getOrdId());
        for (OrderBus bus : busList) {
            OperatorInfoUtil.fillOperateInfo(bus);
            bus.setOrdId(order.getOrdId());
            bus.setOrdBusId(null);
            orderBusDAO.insert(bus);
        }
    }

    @Override
    public void deleteOrder(Integer ordId) {
        orderDAO.delete(ordId, OperatorInfoUtil.getOperateUser().getUsername());
        orderBusDAO.deleteByOrdId(ordId);

    }
}
