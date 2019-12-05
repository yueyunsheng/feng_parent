package com.feng.qa.client;

import org.springframework.stereotype.Component;
import pojo.Result;
import pojo.StatusCode;

@Component
public class LabelClientImpl implements LabelClient {

    @Override
    public Result findLabelById(String id) {
        return new Result(false, StatusCode.ERROR,"熔断器启动了");
    }
}
