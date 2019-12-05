package com.feng.friend.service;

import com.feng.friend.dao.FriendDao;
import com.feng.friend.pojo.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FriendService {

    @Autowired
    private FriendDao friendDao;

    /**
     * 添加好友
     * @param userId
     * @param friendId
     * @return
     */
    public int addFreiend(String userId,String friendId){


        if (friendDao.selectCount(userId,friendId)>0 ) {
            return 0;
        }
        Friend friend = new Friend();
        friend.setUserid(userId);
        friend.setFriendid(friendId);
        friend.setIslike("0");
        friendDao.save(friend);
        /**相互关注**/
        if (friendDao.selectCount(friendId,userId)>0) {
            friendDao.updateLike(userId,friendId,"1");
            friendDao.updateLike(friendId,userId,"1");
        }
        return 1;
    }


}
