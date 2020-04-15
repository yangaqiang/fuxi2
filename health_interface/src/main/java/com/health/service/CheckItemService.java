package com.health.service;

import com.health.pojo.CheckItem;
import com.health.response.CheckItemDto;
import com.health.response.Result;

//检查项的管理接口
public interface CheckItemService {

    //查询所有,返回的是检查项列表
    public Result findAll();

    //根据条件查询带分页
    public Result search(CheckItemDto checkItemDto, Integer page, Integer pagesize);

    //根据id查询
    public Result<CheckItem> findOne(Integer id);

    //根据id修改
    public Result<CheckItem> edit(Integer id, CheckItem checkItem);

    //新增
    public Result<CheckItem> add(CheckItem checkItem);

    //删除
    public Result delete(Integer id);
}
