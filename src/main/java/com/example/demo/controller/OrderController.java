package com.example.demo.controller;

import com.example.demo.dao.IOrderBusDAO;
import com.example.demo.dao.IOrderDAO;
import com.example.demo.domain.BusDomain;
import com.example.demo.domain.OrderBusDomain;
import com.example.demo.domain.OrderDomain;
import com.example.demo.entity.Items;
import com.example.demo.entity.Order;
import com.example.demo.entity.ResponseResult;
import com.example.demo.service.IOrderService;
import com.example.demo.util.OperatorInfoUtil;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.util.ConvertUtils.*;

/**
 * OrderController
 *
 * @author liujinliang
 * @date 2019/5/26
 **/
@RestController
public class OrderController extends BaseController {

    @Autowired
    private IOrderDAO orderDao;

    @Autowired
    private IOrderBusDAO orderBusDAO;

    @Autowired
    private IOrderService orderService;

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ResponseResult addOrder(@RequestBody OrderDomain order){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(STATUS_SUCCESS);
        responseResult.setData("");

        orderService.saveOrder(orderConvertor.apply(order),
                orderBusListConvertor.apply(order.getBusList()));
        return responseResult;
    }

    @RequestMapping(value = "/order", method = RequestMethod.PUT)
    public ResponseResult editOrder(@RequestBody OrderDomain order){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(STATUS_SUCCESS);
        responseResult.setData("");
        orderService.editOrder(orderConvertor.apply(order),
                orderBusListConvertor.apply(order.getBusList()));
        return responseResult;
    }

    @RequestMapping(value = "/order/{ordId}", method = RequestMethod.DELETE)
    public ResponseResult deleteOrder(@PathVariable Integer ordId){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(STATUS_SUCCESS);
        Order order = orderDao.getOrder(ordId);
        OperatorInfoUtil.fillDeleteInfo(order);
        orderDao.delete(order);
        return responseResult;
    }

    @RequestMapping(value = "order/{ordId}", method = RequestMethod.GET)
    public ResponseResult getOrder(@PathVariable Integer ordId){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(STATUS_SUCCESS);
        OrderDomain orderDomain = orderReConvertor.apply(orderDao.getOrder(ordId));
        orderDomain.setBusList(orderBusDAO.listByOrdId(ordId));
        responseResult.setData(orderDomain);
        return responseResult;
    }

    @RequestMapping(value = "/order/table/list", method = RequestMethod.GET)
    public ResponseResult listTable(OrderDomain orderDomain){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(STATUS_SUCCESS);
        List<OrderDomain> domainList =
                ordersReConvertor.apply(orderDao.listOrder(orderDomain, orderDomain.getPage(), orderDomain.getLimit()));
        Items<OrderDomain> items = new Items();
        items.setTotal(orderDao.getListOrderCount(orderDomain, orderDomain.getPage(), orderDomain.getLimit()));
        items.setItems(domainList);
        responseResult.setData(items);
        return responseResult;
    }
}
