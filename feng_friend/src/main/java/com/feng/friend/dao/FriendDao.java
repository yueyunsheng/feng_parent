package com.feng.friend.dao;

import com.feng.friend.pojo.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface FriendDao extends JpaRepository<Friend,String> {


    /**
     * 根据用户id与被关注id查询记录个数
     * @param userId
     * @param friendId
     * @return
     */
    @Query("select count(f) from  Friend  f where f.friendId=?1 and f.userId=?2")
    public int selectCount(String userId,String friendId);

    @Modifying
    @Query("update Friend f set f.islike=?3 where f.userid=?1 and f.friendid=?2")
    void updateLike(String userId,String friendId,String isLike);

}
