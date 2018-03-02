package net.lainiao.myqq.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import net.lainiao.myqq.dao.AccountMapper;
import net.lainiao.myqq.entity.Account;
import net.lainiao.myqq.model.DataList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountMapper accountMapper;

    @CachePut(value = "account", key = "#account.id")
    public Account login(Account account) {
        return accountMapper.login(account);
    }

    public int insert(Account account) {
        return accountMapper.insert(account);
    }

    @CacheEvict(value = "account",key = "#account.id")
    public Account update(Account account){
         accountMapper.updateByPrimaryKeySelective(account);
         return accountMapper.selectByPrimaryKey(account.getId());
    }

    public DataList<Account> searchFriend(String keyWord,int pageIndex,int pageSize) {
        Page page=PageHelper.startPage(pageIndex,pageSize);
        List<Account> accounts=accountMapper.searchFriend(keyWord);
        DataList<Account> dataList=new DataList<>(pageSize,(int) page.getTotal());
        dataList.setData(accounts);
        dataList.setPageIndex(pageIndex);
        return dataList;
    }

    @Cacheable(value = "account", key = "#account.id")
    public Account selectByPrimaryKey(int id) {
        return accountMapper.selectByPrimaryKey(id);
    }

    public List<Account> getFriends(int id) {
        return accountMapper.getFriends(id);
    }

    public int getCountByUserName(String username) {
        return accountMapper.getCountByUserName(username);
    }
}
