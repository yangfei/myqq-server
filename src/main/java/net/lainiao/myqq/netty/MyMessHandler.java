package net.lainiao.myqq.netty;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;
import net.lainiao.myqq.ApplicationStartup;
import net.lainiao.myqq.chat.*;
import net.lainiao.myqq.model.CommonMess;
import net.lainiao.myqq.model.MessType;
import org.springframework.context.ApplicationContext;


public class MyMessHandler {
   private static CommonHandler registerHandler=null;
   private static CommonHandler loginHandler=null;
   private static CommonHandler searchfriendHandler=null;
   private static CommonHandler defaultHandler=null;
   private static CommonHandler addFriendHandler=null;
   private static CommonHandler getSysMessHandler=null;
   private static CommonHandler agreeAddFriendHandler=null;
   private static CommonHandler getFriendsHandler=null;
   private static CommonHandler sendMessHandler=null;
   private static CommonHandler getOffLineChatMessHandler=null;
   private static CommonHandler loginOutHandler=null;
   private static CommonHandler editInfoHandler=null;
   static{
       ApplicationContext context=ApplicationStartup.context;
       registerHandler=context.getBean(RegisterHandler.class);
       loginHandler=context.getBean(LoginHandler.class);
       searchfriendHandler= context.getBean(SearchFriendHandler.class);
       defaultHandler= context.getBean(DeafultHandler.class);
       addFriendHandler= context.getBean(AddFriendHandler.class);
       getSysMessHandler= context.getBean(GetSysMessHandler.class);
       agreeAddFriendHandler= context.getBean(AgreeAddFriendHandler.class);
       getFriendsHandler=context.getBean(GetFriendsHandler.class);
       sendMessHandler=context.getBean(SendChatMesHandler.class);
       getOffLineChatMessHandler=context.getBean(GetOffLineChatMessHandler.class);
       loginOutHandler=context.getBean(LoginOutHandler.class);
       editInfoHandler=context.getBean(EditInfoHandler.class);
   }

   public static void executer(ChannelHandlerContext ctx,String requestJson){
       ctx.executor().execute(new Runnable() {
           @Override
           public void run() {
               MyMessHandler.handler(ctx,requestJson);
           }
       });
   }

   public static void handler(ChannelHandlerContext ctx,String requestJson){
       CommonMess commonMess = JSONObject.parseObject(requestJson,CommonMess.class);
       switch (commonMess.getMessType()){
           case MessType.Register:
               registerHandler.handler(ctx, commonMess);
               break;
           case MessType.Login:
               loginHandler.handler(ctx, commonMess);
               break;
           case MessType.SearchFriend:
               searchfriendHandler.handler(ctx, commonMess);
               break;
           case MessType.AddFriend:
               addFriendHandler.handler(ctx, commonMess);
               break;
           case MessType.GetSysMess:
               getSysMessHandler.handler(ctx,commonMess);
               break;
           case MessType.AgreeAddFriend:
               agreeAddFriendHandler.handler(ctx,commonMess);
               break;
           case MessType.GetFriends:
               getFriendsHandler.handler(ctx,commonMess);
               break;
           case MessType.GetOffLineChatMess:
               getOffLineChatMessHandler.handler(ctx,commonMess);
               break;
           case MessType.SendChatMess:
               sendMessHandler.handler(ctx,commonMess);
               break;
           case MessType.LoginOut:
               loginOutHandler.handler(ctx,commonMess);
               break;
           case MessType.EditInfo:
               editInfoHandler.handler(ctx,commonMess);
               break;
           default:
               defaultHandler.handler(ctx, commonMess);
               break;
       }
   }


}
