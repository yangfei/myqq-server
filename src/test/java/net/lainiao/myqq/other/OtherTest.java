package net.lainiao.myqq.other;

import com.alibaba.fastjson.JSONObject;
import net.lainiao.myqq.entity.Account;
import org.junit.Test;

import java.util.Date;

public class OtherTest {
    @Test
    public void testDateJSON(){
        Account account=new Account();
        account.setCreatetime(new Date());
        String json= JSONObject.toJSONString(account);
        System.out.println(json);
    }
}
