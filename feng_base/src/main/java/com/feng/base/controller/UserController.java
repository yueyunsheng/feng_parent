package com.feng.base.controller;

import com.feng.base.pojo.Label;
import com.feng.base.service.LabelService;
import org.springframework.web.bind.annotation.*;
import pojo.Result;
import pojo.StatusCode;

import javax.annotation.Resource;

@RequestMapping("/label")
@RestController
public class UserController {

    @Resource
    private LabelService labelService;


    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
          return new Result(true, StatusCode.OK,"查询成功",
                  labelService.findLabelList()  );
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result findLabelById(@PathVariable String id){
        return new Result(true,StatusCode.OK,"查询成功",
                labelService.findLabelById(id) );
    }

    @RequestMapping(method = RequestMethod.POST )
    public Result addLabel(@RequestBody  Label label){
        System.out.println(label);
        labelService.addLabel(label);
        return new Result(true,StatusCode.OK,"添加成功" );
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public  Result updateLabel(@RequestBody Label label,@PathVariable String
            id){
        label.setId(id);
        labelService.updateLabel(label);
        return new Result(true,StatusCode.OK,"修改成功");
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result deleteLabel(String id){
        labelService.deleteLabelById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }




}
