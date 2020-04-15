package com.health.mapper;

import com.health.pojo.CheckItem;
import com.health.response.Result;

import java.util.List;

public interface CheckItemMapper {

    //查询所有,返回的是检查项列表
    public Result findAll();

    //根据条件查询带分页
    public List<CheckItem> search(CheckItem checkItem);

    //根据id查询
    public CheckItem findOne(Integer id);

    //根据id修改
    public void edit(CheckItem checkItem);

    //新增
    public void add(CheckItem checkItem);

    //删除
    public void delete(Integer id);
}
