package com.example.demo.controller;

import com.example.demo.dao.ICostDAO;
import com.example.demo.domain.CostDomain;
import com.example.demo.entity.Bus;
import com.example.demo.entity.Cost;
import com.example.demo.entity.Items;
import com.example.demo.entity.ResponseResult;
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
    private ICostDAO costDAO;

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
                costListReConvertor.apply(costDAO.listCost(costDomain, costDomain.getPage(), costDomain.getLimit()));
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
