package net.lainiao.myqq.dao;

import net.lainiao.myqq.entity.SysMess;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysMessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMess record);

    int insertSelective(SysMess record);

    SysMess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMess record);

    int updateByPrimaryKey(SysMess record);

    List<SysMess> getMessByAccount(int id);
}