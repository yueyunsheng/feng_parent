package com.feng.qa.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pojo.Result;

@FeignClient("feng-base")
public interface LabelClient {


    @RequestMapping(value = "/label/{id}",method = RequestMethod.GET)
     public Result findLabelById(@PathVariable("id") String id);

}