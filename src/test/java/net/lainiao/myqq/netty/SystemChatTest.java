package net.lainiao.myqq.netty;

import com.alibaba.fastjson.JSONObject;
import net.lainiao.myqq.model.CommonMess;
import net.lainiao.myqq.model.LoginRequestModel;
import net.lainiao.myqq.model.MessType;
import org.junit.Test;

import java.net.URISyntaxException;

public class SystemChatTest  extends RunServerTest {

    @Test
    public void testLogin3() throws URISyntaxException, InterruptedException {
        LoginRequestModel account=new LoginRequestModel();
        account.setUsername("lainiao3");
        account.setUserpass("lainiao");
        CommonMess mess=new CommonMess();
        mess.setMessType(MessType.Login);
        mess.setContent(JSONObject.toJSONString(account));
        String sendJson=JSONObject.toJSONString(mess);
        super.testSocket(sendJson);
    }

    @Test
    public void testLogin5() throws URISyntaxException, InterruptedException {
        LoginRequestModel account=new LoginRequestModel();
        account.setUsername("lainiao5");
        account.setUserpass("lainiao");
        CommonMess mess=new CommonMess();
        mess.setMessType(MessType.Login);
        mess.setContent(JSONObject.toJSONString(account));
        String sendJson=JSONObject.toJSONString(mess);
        super.testSocket(sendJson);
    }

}
