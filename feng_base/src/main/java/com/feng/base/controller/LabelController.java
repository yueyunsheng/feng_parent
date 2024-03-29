package com.feng.base.controller;

import com.feng.base.pojo.Label;
import com.feng.base.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import pojo.PageResult;
import pojo.Result;
import pojo.StatusCode;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RequestMapping("/label")
@RestController
public class LabelController {

    @Resource
    private LabelService labelService;

    @Autowired
    private HttpServletRequest request;


    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        System.out.println(request.getHeader("Authorization"));
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


    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public Result findSearch(@RequestBody Label label){
        return new Result(true,StatusCode.OK,"查询成功",labelService.findSearch(label));
    }

    @RequestMapping(value = "/search/{page}/{size}",method = RequestMethod.POST)
    public Result pageQuery(@RequestBody Label label,@PathVariable int page,@PathVariable int size){
        Page<Label> pageData = labelService.pageQuery(label,page,size);
        return new Result(true,StatusCode.OK,"查询成功",
                new PageResult<Label>(pageData.getTotalElements(),pageData.getContent()));
    }

}
