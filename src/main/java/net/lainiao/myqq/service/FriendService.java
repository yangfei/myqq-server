package net.lainiao.myqq.service;

import net.lainiao.myqq.dao.FriendMapper;
import net.lainiao.myqq.entity.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 2018/2/25.
 */
@Service
public class FriendService {
    @Autowired
    FriendMapper friendMapper;

    public void createFriend(Friend friend) {
        int count=friendMapper.selectFriend(friend);
        if(count==0){
            friend.setCreatetime(new Date());
            friendMapper.insert(friend);
        }
    }
}
