package com.example.demo.util;

import com.example.demo.dao.IBusDAO;
import com.example.demo.domain.BusDomain;
import com.example.demo.domain.CostDomain;
import com.example.demo.domain.OrderBusDomain;
import com.example.demo.domain.OrderDomain;
import com.example.demo.entity.Bus;
import com.example.demo.entity.Cost;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderBus;
import com.google.common.base.Function;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * ConvertUtils
 *
 * @author liujinliang
 * @date 2019/5/19
 **/
public class ConvertUtils {

    public static Function<BusDomain, Bus> busConvertor = o -> {
        Bus bus = new Bus();
        BeanUtils.copyProperties(o, bus);
        bus.setBusModel(Integer.valueOf(o.getBusModel()));
        return bus;
    };

    public static Function<Bus, BusDomain> busReConvertor = o -> {
        BusDomain bus = new BusDomain();
        BeanUtils.copyProperties(o, bus);
        bus.setBusModel(String.valueOf(o.getBusModel()));
        return bus;
    };

    public static Function<List<Bus>, List<BusDomain>> busesReConvertor = o -> {
        List<BusDomain> busDomains = new ArrayList<>();
        for (Bus bus : o) {
            BusDomain busDomain = new BusDomain();
            BeanUtils.copyProperties(bus, busDomain);
            busDomain.setBusModel(String.valueOf(bus.getBusModel()));
            OperatorInfoUtil.fillOperateInfo(bus);
            busDomains.add(busDomain);
        }
        return busDomains;
    };

    public static Function<List<OrderBusDomain>, List<OrderBus>> orderBusListConvertor = o -> {
        List<OrderBus> busList = new ArrayList<>();
        for (OrderBusDomain busDomain : o) {
            OrderBus bus = new OrderBus();
            BeanUtils.copyProperties(busDomain, bus);
            OperatorInfoUtil.fillOperateInfo(busDomain);
            busList.add(bus);
        }
        return busList;
    };

    public static Function<List<OrderBus>, List<OrderBusDomain>> orderBusListReConvertor = o -> {
        List<OrderBusDomain> busList = new ArrayList<>();
        for (OrderBus busDomain : o) {
            OrderBusDomain bus = new OrderBusDomain();
            BeanUtils.copyProperties(busDomain, bus);
            OperatorInfoUtil.fillOperateInfo(busDomain);
            busList.add(bus);
        }
        return busList;
    };

    public static Function<OrderDomain, Order> orderConvertor = o -> {
        Order order = new Order();
        BeanUtils.copyProperties(o, order);
        order.setContainCost(o.getContainCost() ? 1 : 0);
        return order;
    };

    public static Function<Order, OrderDomain> orderReConvertor = o -> {
        OrderDomain order = new OrderDomain();
        BeanUtils.copyProperties(o, order);
        order.setContainCost(1 == o.getContainCost());
        return order;
    };

    public static Function<List<Order>, List<OrderDomain>> ordersReConvertor = o -> {
        List<OrderDomain> orderDomains = new ArrayList<>();
        for (Order order : o) {
            OrderDomain orderDomain = new OrderDomain();
            BeanUtils.copyProperties(order, orderDomain);
            OperatorInfoUtil.fillOperateInfo(order);
            orderDomains.add(orderDomain);
        }
        return orderDomains;
    };

    public static Function<CostDomain, Cost> costConvertor = o -> {
        Cost bus = new Cost();
        BeanUtils.copyProperties(o, bus);
        bus.setCostAmount(new BigDecimal(o.getCostAmount()));
        return bus;
    };

    public static Function<Cost, CostDomain> costReConvertor = o -> {
        CostDomain bus = new CostDomain();
        BeanUtils.copyProperties(o, bus);
        bus.setCostAmount(String.valueOf(o.getCostAmount()));
        return bus;
    };

    public static Function<List<Cost>, List<CostDomain>> costListReConvertor = o -> {
        List<CostDomain> costList = new ArrayList<>();
        for (Cost costDomain : o) {
            CostDomain cost = new CostDomain();
            BeanUtils.copyProperties(costDomain, cost);
            OperatorInfoUtil.fillOperateInfo(costDomain);
            cost.setCostAmount(String.valueOf(costDomain.getCostAmount()));
            costList.add(cost);
        }
        return costList;
    };
}
