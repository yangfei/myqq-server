package net.lainiao.myqq.service;

import net.lainiao.myqq.dao.SysMessMapper;
import net.lainiao.myqq.entity.SysMess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/2/25.
 */
@Service
public class SysMessService {
    @Autowired
    SysMessMapper sysMessMapper;

    public int insert(SysMess sysMess) {
        return sysMessMapper.insert(sysMess);
    }

    public int delete(Integer id) {
        return sysMessMapper.deleteByPrimaryKey(id);
    }

    public List<SysMess> getMessByAccount(int id) {
        return sysMessMapper.getMessByAccount(id);
    }
}
