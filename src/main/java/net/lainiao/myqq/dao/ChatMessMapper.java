package net.lainiao.myqq.dao;

import net.lainiao.myqq.entity.ChatMess;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChatMess record);

    int insertSelective(ChatMess record);

    ChatMess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChatMess record);

    int updateByPrimaryKeyWithBLOBs(ChatMess record);

    int updateByPrimaryKey(ChatMess record);

    List<ChatMess> getOffLineChatMessByAccount(int id);
}