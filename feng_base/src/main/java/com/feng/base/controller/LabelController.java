package com.feng.base.controller;

import com.feng.base.pojo.Label;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pojo.Result;
import pojo.StatusCode;

import java.util.List;

@RestController
public class LabelController {

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public Result findSearch(@RequestBody Label label){

        List<Label> list = labelService.findSearch(label);
        return  new Result(true, StatusCode.OK,"查询成功",list);
    }


}
