package net.lainiao.myqq.chat;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;
import net.lainiao.myqq.entity.Account;
import net.lainiao.myqq.model.*;
import net.lainiao.myqq.model.CommonMess;
import net.lainiao.myqq.netty.Global;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchFriendHandler  extends CommonHandler  {

    public void handler(ChannelHandlerContext ctx, CommonMess commonMess) {
        SearchFriendRequestModel requestModel= JSONObject.parseObject(commonMess.getContent(),SearchFriendRequestModel.class);
        DataList<Account> dataList=accountService.searchFriend(requestModel.getKeyWord(),requestModel.getPageIndex(),requestModel.getPageSize());
        SearchFriendResponseModel responseModel=new SearchFriendResponseModel();
        responseModel.setState(1);
        DataList<LoginResponseModel> temList=new DataList<>();
        temList.setPageCount(dataList.getPageCount());
        temList.setPageIndex(dataList.getPageIndex());
        temList.setPageSize(dataList.getPageSize());
        temList.setTotal(dataList.getTotal());
        List<LoginResponseModel> list=new ArrayList<>();
        temList.setData(list);
        for(Account account:dataList.getData()){
            LoginResponseModel temModel=new LoginResponseModel();
            temModel.setAge(account.getAge());
            temModel.setBlood(account.getBlood());
            temModel.setConste(account.getConste());
            temModel.setCreatetime(account.getCreatetime());
            temModel.setGender(account.getGender());
            temModel.setId(account.getId());
            temModel.setNickname(account.getNickname());
            temModel.setUsername(account.getUsername());
            if(Global.currentChannel.containsKey(account.getId())){
                temModel.setLineState(1);
            }else{
                temModel.setLineState(0);
            }
            list.add(temModel);
        }
        responseModel.setDataList(temList);
        responseClient(ctx,-MessType.SearchFriend,responseModel);
    }
}
