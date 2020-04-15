package com.health.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.health.pojo.CheckItem;
import com.health.response.CheckItemDto;
import com.health.response.Result;
import com.health.service.CheckItemService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("checkitem")
public class CheckItemController {
    @Reference
    CheckItemService checkItemService;
    //查询所有
    public Result<CheckItem> findAll(){
        //1.接受参数
        //2.调用service
        //3.返回结果
        return checkItemService.findAll();
    }

    //根据条件查询带分页
    @GetMapping("/search")
    public Result search(@RequestBody CheckItemDto checkItemDto, @RequestParam("page") Integer page,@RequestParam("pagesize")Integer pagesize){
    return checkItemService.search(checkItemDto,page,pagesize);
    }

    //根据id查询
    @GetMapping("findOne")
    public Result<CheckItem> findOne(Integer id){
        return checkItemService.findOne(id);
    }

    //根据id修改
    @PutMapping
    public Result<CheckItem> edit(Integer id ,@RequestBody CheckItem checkItem){
        return checkItemService.edit(id,checkItem);
    }

    //新增
        @PostMapping
    public Result<CheckItem> add(CheckItem checkItem){
        return checkItemService.add(checkItem);
    }

    //删除
    @DeleteMapping
    public Result delete(Integer id){
        return checkItemService.delete(id);
    }
}
