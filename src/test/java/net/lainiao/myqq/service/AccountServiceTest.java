package net.lainiao.myqq.service;

import net.lainiao.myqq.MyqqApplicationTests;
import net.lainiao.myqq.dao.AccountMapper;
import net.lainiao.myqq.entity.Account;
import net.lainiao.myqq.model.DataList;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceTest extends MyqqApplicationTests {

    @Autowired
    AccountMapper accountMapper;
    @Autowired
    AccountService accountService;

    @Test
    public void testLogin(){
        Account account=new Account();
        account.setUsername("lainiao");
        account.setUserpass("lainiao");
        Account account1=accountMapper.login(account);
        Assert.assertNotNull(account1);
    }

    @Test
    public void testInsert(){
        Account account=new Account();
        account.setNickname("1");
        account.setUsername("1");
        account.setUserpass("1");
        account.setGender("1");
        account.setBlood("1");
        account.setConste("1");
        account.setAge(1);
        int count=accountMapper.insert(account);
        System.out.println("AccountCount:"+count);
        System.out.println("AccountCount:"+account.getId());
    }

    @Test
    public void testSearchFriend(){
        DataList<Account> dataList=accountService.searchFriend("lainiao",1,10);
        Assert.assertNotEquals(dataList.getTotal(),0);
        System.out.println("FriendCount:"+ dataList.getTotal()+"  "+dataList.getPageCount());
    }
}
