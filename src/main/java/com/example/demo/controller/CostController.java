package com.example.demo.controller;

import com.example.demo.mapper.BusDAO;
import com.example.demo.mapper.CostDAO;
import com.example.demo.mapper.OrderBusDAO;
import com.example.demo.mapper.OrderDAO;
import com.example.demo.domain.CostDomain;
import com.example.demo.entity.*;
import com.example.demo.util.OperatorInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.util.ConvertUtils.*;

/**
 * CostController
 *
 * @author liujinliang
 * @date 2019/6/1
 **/
@RestController
public class CostController extends BaseController{

    @Autowired
    private CostDAO costDAO;
    @Autowired
    private OrderBusDAO orderBusDAO;
    @Autowired
    private BusDAO busDAO;
    @Autowired
    private OrderDAO orderDAO;

    @RequestMapping(value = "cost", method = RequestMethod.POST)
    public ResponseResult addCost(@RequestBody CostDomain costDomain){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(STATUS_SUCCESS);
        responseResult.setData("");

        Cost cost = costConvertor.apply(costDomain);
        OperatorInfoUtil.fillOperateInfo(cost);
        costDAO.insert(cost);
        return responseResult;
    }

    @RequestMapping(value = "/cost/table/list", method = RequestMethod.GET)
    public ResponseResult listTable(CostDomain costDomain){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(STATUS_SUCCESS);
        List<CostDomain> domainList =
                costListReConvertor.apply(costDAO.listCost(costDomain, (costDomain.getPage() - 1) * costDomain.getLimit(), costDomain.getLimit()));
        for (CostDomain domain : domainList) {
            Bus bus;
            if("order".equals(domain.getCostRelatedModel())){
                OrderBus orderBus = orderBusDAO.selectByPrimaryKey(domain.getCostRelatedId());
                if(orderBus == null){
                    continue;
                }
                Order order = orderDAO.selectByPrimaryKey(orderBus.getOrdId());
                domain.setUseBusStartTime(order.getUseBusStartTime());
                domain.setUseBusEndTime(order.getUseBusEndTime());
                bus = busDAO.getBus(Long.valueOf(orderBus.getBusId()));
            } else {
                bus = busDAO.getBus(Long.valueOf(domain.getCostRelatedId()));
            }
            domain.setBusDomain(busReConvertor.apply(bus));
        }
        Items<CostDomain> items = new Items();
        items.setTotal(costDAO.getListCostCount(costDomain, costDomain.getPage(), costDomain.getLimit()));
        items.setItems(domainList);
        responseResult.setData(items);
        return responseResult;
    }

    @RequestMapping(value = "/cost/{costId}", method = RequestMethod.DELETE)
    public ResponseResult deleteCost(@PathVariable Integer costId){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(STATUS_SUCCESS);
        Cost bus = costDAO.getCost(costId);
        OperatorInfoUtil.fillDeleteInfo(bus);
        costDAO.delete(bus);
        return responseResult;
    }
}
