package net.lainiao.myqq.service;

import net.lainiao.myqq.dao.ChatMessMapper;
import net.lainiao.myqq.entity.ChatMess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/2/25.
 */
@Service
public class ChatMessService {

    @Autowired
    ChatMessMapper chatMessMapper;

    public int insert(ChatMess chatMess) {
        return chatMessMapper.insert(chatMess);
    }

    public List<ChatMess> getOffLineChatMessByAccount(int id){
        return chatMessMapper.getOffLineChatMessByAccount(id);
    }

    public int delete(Integer id) {
        return chatMessMapper.deleteByPrimaryKey(id);
    }
}
