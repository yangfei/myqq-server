package net.lainiao.myqq.netty;

import com.alibaba.fastjson.JSONObject;
import net.lainiao.myqq.model.*;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;



public class RunServerTest {
    private WebSocketClient client=null;

    void testSocket(String sendJson) throws InterruptedException, URISyntaxException {
        URI uri=new URI("ws://localhost:8888");
        final WebSocketClient client=new WebSocketClient(uri) {
            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                System.out.println("连接打开");
                this.send(sendJson);
            }

            @Override
            public void onMessage(String s) {
                System.out.println("收到消息:"+s);
            }

            @Override
            public void onClose(int i, String s, boolean b) {
                System.out.println("连接关闭");
            }

            @Override
            public void onError(Exception e) {
                System.out.println("系统异常");
                System.err.println(e.fillInStackTrace());
            }
        };
        client.connect();
        Thread.sleep(100000);
    }

    @Test
    public void testRegister() throws URISyntaxException, InterruptedException {
        RegisetRequestModel account=new RegisetRequestModel();
        account.setUsername("lainiao");
        account.setAge(12);
        account.setConste("无名座");
        account.setBlood("A");
        account.setNickname("熊猫");
        account.setGender("男");
        account.setUserpass("lainiao");
        CommonMess mess=new CommonMess();
        mess.setMessType(MessType.Register);
        mess.setContent(JSONObject.toJSONString(account));
        String sendJson=JSONObject.toJSONString(mess);
        testSocket(sendJson);
    }


    @Test
    public void testSearchFriend() throws URISyntaxException, InterruptedException {
        SearchFriendRequestModel requestModel=new SearchFriendRequestModel();
        requestModel.setKeyWord("lainiao");
        requestModel.setPageIndex(1);
        requestModel.setPageSize(10);
        CommonMess mess=new CommonMess();
        mess.setMessType(MessType.SearchFriend);
        mess.setContent(JSONObject.toJSONString(requestModel));
        String sendJson=JSONObject.toJSONString(mess);
        testSocket(sendJson);
    }

    @Test
    public void testAddFriend() throws URISyntaxException, InterruptedException {
        AddFriendRequestModel requestModel=new AddFriendRequestModel();
        requestModel.setId(10004);
        requestModel.setTargetId(10005);
        requestModel.setMess("加个朋友呗");
        CommonMess mess=new CommonMess();
        mess.setMessType(MessType.AddFriend);
        mess.setContent(JSONObject.toJSONString(requestModel));
        String sendJson=JSONObject.toJSONString(mess);
        testSocket(sendJson);
    }

    @Test
    public void testGetSysMess() throws URISyntaxException, InterruptedException {
        GetSysMessRequestModel requestModel=new GetSysMessRequestModel();
        requestModel.setId(10005);
        CommonMess mess=new CommonMess();
        mess.setMessType(MessType.GetSysMess);
        mess.setContent(JSONObject.toJSONString(requestModel));
        String sendJson=JSONObject.toJSONString(mess);
        testSocket(sendJson);
    }

    @Test
    public void testAgreeAddFriend() throws URISyntaxException, InterruptedException {
        AgreenAddFriendRequestModel requestModel=new AgreenAddFriendRequestModel();
        requestModel.setId(10005);
        requestModel.setTargetId(10003);
        requestModel.setResult(1);
        CommonMess mess=new CommonMess();
        mess.setMessType(MessType.AgreeAddFriend);
        mess.setContent(JSONObject.toJSONString(requestModel));
        String sendJson=JSONObject.toJSONString(mess);
        testSocket(sendJson);
    }


    @Test
    public void testGetFriends() throws URISyntaxException, InterruptedException {
        GetFriendsRequestModel requestModel=new GetFriendsRequestModel();
        requestModel.setId(10005);
        CommonMess mess=new CommonMess();
        mess.setMessType(MessType.GetFriends);
        mess.setContent(JSONObject.toJSONString(requestModel));
        String sendJson=JSONObject.toJSONString(mess);
        testSocket(sendJson);
    }

    @Test
    public void testSendChatmess() throws URISyntaxException, InterruptedException {
        SendChatMessRequestModel requestModel=new SendChatMessRequestModel();
        requestModel.setId(10005);
        requestModel.setTargetId(10003);
        requestModel.setContent("你是我的小雅削苹果");
        requestModel.setTargetType(0);
        CommonMess mess=new CommonMess();
        mess.setMessType(MessType.SendChatMess);
        mess.setContent(JSONObject.toJSONString(requestModel));
        String sendJson=JSONObject.toJSONString(mess);
        testSocket(sendJson);
    }

    @Test
    public void testGetOffLineChatMess() throws URISyntaxException, InterruptedException {
        GetOffLineChatMessRequestModel requestModel=new GetOffLineChatMessRequestModel();
        requestModel.setId(10003);
        CommonMess mess=new CommonMess();
        mess.setMessType(MessType.GetOffLineChatMess);
        mess.setContent(JSONObject.toJSONString(requestModel));
        String sendJson=JSONObject.toJSONString(mess);
        testSocket(sendJson);
    }
}
