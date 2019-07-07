package com.example.demo.controller;

import com.example.demo.domain.OrderBusDomain;
import com.example.demo.entity.OrderBus;
import com.example.demo.mapper.OrderBusDAO;
import com.example.demo.mapper.OrderDAO;
import com.example.demo.domain.OrderDomain;
import com.example.demo.entity.Items;
import com.example.demo.entity.ResponseResult;
import com.example.demo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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
    private OrderDAO orderDao;

    @Autowired
    private OrderBusDAO orderBusDAO;

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
        orderService.deleteOrder(ordId);
        return responseResult;
    }

    @RequestMapping(value = "order/{ordId}", method = RequestMethod.GET)
    public ResponseResult getOrder(@PathVariable Integer ordId){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(STATUS_SUCCESS);
        OrderDomain orderDomain = orderReConvertor.apply(orderDao.getOrder(ordId));

        List<OrderBus> orderBusDomains = orderBusDAO.listByOrdId(ordId);
        List<OrderBusDomain> apply = orderBusListReConvertor.apply(orderBusDomains);
//        for (OrderBusDomain orderBusDomain : apply) {
//            orderBusDomain.setBusCost(BigDecimal.ONE);
//        }
        orderDomain.setBusList(apply);
        responseResult.setData(orderDomain);
        return responseResult;
    }

    @RequestMapping(value = "/order/table/list", method = RequestMethod.GET)
    public ResponseResult listTable(OrderDomain orderDomain){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(STATUS_SUCCESS);
        List<OrderDomain> domainList =
                ordersReConvertor.apply(orderDao.listOrder(orderDomain, (orderDomain.getPage() - 1) * orderDomain.getLimit(), orderDomain.getLimit()));
        Items<OrderDomain> items = new Items();
        items.setTotal(orderDao.getListOrderCount(orderDomain, orderDomain.getPage(), orderDomain.getLimit()));
        for (OrderDomain domain : domainList) {
            domain.setBusList(orderBusListReConvertor.apply(orderBusDAO.listByOrdId(domain.getOrdId())));
        }
        items.setItems(domainList);
        responseResult.setData(items);
        return responseResult;
    }
}
