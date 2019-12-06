package com.feng.friend.controller;

import com.feng.friend.service.FriendService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pojo.Result;
import pojo.StatusCode;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/friend")
public class FriendController {


    @Autowired
    private FriendService friendService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/like/{friendId}/{type}",method = RequestMethod.PUT)
    public Result addFriend(String friendId, String type){


        Claims claims = (Claims) request.getAttribute("user_claims");

        if (claims==null) {
            return new Result(false, StatusCode.ACCESSERROR,"无权限！");
        }
        int res =  friendService.addFreiend(claims.getId(),friendId);
        if (res>0) {
            return new Result(true, StatusCode.OK,"添加好友成功！");
        }else{
            return new Result(false,StatusCode.ERROR,"添加好友失败!");
        }
    }
}
