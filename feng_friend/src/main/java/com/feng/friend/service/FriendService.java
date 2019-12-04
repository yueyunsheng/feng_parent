package com.feng.friend.service;

import com.feng.friend.dao.FriendDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendService {

    @Autowired
    private FriendDao friendDao;

    public int addFreiend(){

        return 0;
    }

}
