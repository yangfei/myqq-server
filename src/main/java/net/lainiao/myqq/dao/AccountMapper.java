package net.lainiao.myqq.dao;

import net.lainiao.myqq.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    Account login(Account account);

    List<Account> searchFriend(String keyword);

    List<Account> getFriends(int id);

    String getNickName(Integer id);

    int getCountByUserName(String username);
}