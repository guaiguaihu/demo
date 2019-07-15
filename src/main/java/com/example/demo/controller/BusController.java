package com.example.demo.controller;

import com.example.demo.mapper.BusDAO;
import com.example.demo.mapper.OrderDAO;
import com.example.demo.domain.BusDomain;
import com.example.demo.entity.*;
import com.example.demo.util.OperatorInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.util.ConvertUtils.*;

/**
 * BusController
 *
 * @author liujinliang
 * @date 2019/5/19
 **/
@RestController
public class BusController extends BaseController {

    @Autowired
    private BusDAO busDao;
    @Autowired
    private OrderDAO orderDAO;

    @RequestMapping(value = "/bus", method = RequestMethod.POST)
    public ResponseResult addBus(@RequestBody BusDomain bus){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(STATUS_SUCCESS);
        responseResult.setData("");

        Bus busSave = busConvertor.apply(bus);
        OperatorInfoUtil.fillOperateInfo(busSave);
        busDao.insert(busSave);
        return responseResult;
    }

    @RequestMapping(value = "/bus", method = RequestMethod.PUT)
    public ResponseResult editBus(@RequestBody BusDomain bus){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(STATUS_SUCCESS);
        responseResult.setData("");

        Bus busUpdate = busConvertor.apply(bus);
        OperatorInfoUtil.fillUpdateInfo(busUpdate);
        busDao.update(busUpdate);
        return responseResult;
    }

    @RequestMapping(value = "/bus/{busId}", method = RequestMethod.DELETE)
    public ResponseResult editBus(@PathVariable Long busId){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(STATUS_SUCCESS);
        Bus bus = busDao.getBus(busId);
        OperatorInfoUtil.fillDeleteInfo(bus);
        busDao.delete(bus);
        return responseResult;
    }

    @RequestMapping(value = "bus/{busId}", method = RequestMethod.GET)
    public ResponseResult getBus(@PathVariable Long busId){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(STATUS_SUCCESS);
        responseResult.setData(busReConvertor.apply(busDao.getBus(busId)));
        return responseResult;
    }

    @RequestMapping(value = "/bus/table/list", method = RequestMethod.GET)
    public ResponseResult listTable(BusDomain busDomain){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(STATUS_SUCCESS);
        List<BusDomain> domainList =
                busesReConvertor.apply(busDao.listBus(busDomain, busDomain.getOffset(), busDomain.getLimit()));
        Items<BusDomain> items = new Items();
        items.setTotal(busDao.getListBusCount(busDomain));
        items.setItems(domainList);
        for (BusDomain domain : domainList) {
            domain.setOrderDomainList(ordersReConvertor.apply(orderDAO.listUsingOrder(domain.getBusId())));
            if(!CollectionUtils.isEmpty(domain.getOrderDomainList())){
                domain.setStatus("已预定");
            } else {
                domain.setStatus("未预定");
            }
        }
        responseResult.setData(items);
        return responseResult;
    }
}
