package com.health.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.health.constant.MessageConstant;
import com.health.mapper.CheckItemMapper;
import com.health.pojo.CheckItem;
import com.health.response.CheckItemDto;
import com.health.response.PageResult;
import com.health.response.Result;
import com.health.service.CheckItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(interfaceClass = CheckItemService.class)
public class CheckItemServiceImpl implements CheckItemService {

    @Autowired
    CheckItemMapper checkItemMapper;
    /**
     * 查询所有
     */
    @Override
    public Result findAll() {
        //1.参数校验

        //2.业务流程
        List<CheckItem> all = (List<CheckItem>) checkItemMapper.findAll();
        if (all==null || all.size()==0){
            return new Result("无查询结果");
        }
        //3.封装执行结果
        return new Result(true, MessageConstant.QUERY_CHECKITEM_SUCCESS,all);
    }
    //查询所有带分页
    @Override
    public Result search(CheckItemDto checkItemDto, Integer page, Integer pagesize) {
        //参数校验
        if (page==null){
            page=1;
        }
        if (pagesize==null){
            pagesize=10;
        }
        CheckItem checkItem = new CheckItem();
        BeanUtils.copyProperties(checkItemDto,checkItem);
        //只对下面的一个有效
        PageHelper.startPage(page,pagesize);
        //执行业务逻辑
        Page<CheckItem> search = (Page<CheckItem>)checkItemMapper.search(checkItem);
        if (search==null || search.getTotal()==0){
            return new Result<>("查询失败");
        }
        //封装结果
        PageResult<CheckItem> pageResult = new PageResult<>();
        pageResult.setTotal(search.getTotal());
        pageResult.setRows(search.getResult());
        return new Result<>(search);
    }
    //根据id查询
    @Override
    public Result<CheckItem> findOne(Integer id) {
        CheckItem one = checkItemMapper.findOne(id);
        if (one==null){
            return new Result<>("没有查询到");
        }

        return new Result<>(one);
    }
    //根据Id修改
    @Override
    public Result<CheckItem> edit(Integer id, CheckItem checkItem) {
        CheckItem one = checkItemMapper.findOne(id);
        if (one==null){
            return new Result<>("不可修改");
        }
        checkItem.setId(id);
        checkItemMapper.edit(checkItem);
        //执行成功
        return new Result<>(true, MessageConstant.EDIT_CHECKITEM_SUCCESS);
    }
    //新增
    @Override
    public Result<CheckItem> add(CheckItem checkItem) {
        checkItemMapper.add(checkItem);
        return new Result<>(checkItem);
    }
    //删除
    @Override
    public Result delete(Integer id) {
        checkItemMapper.delete(id);
        return new Result(true, MessageConstant.DELETE_CHECKITEM_SUCCESS);
    }
}
