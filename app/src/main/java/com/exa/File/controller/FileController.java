package com.exa.File.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.exa.entity.File;
import com.exa.mapper.FileMapper;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.EmptyResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author leo
 * @since 2021-11-09
 */
@RestController
@RequestMapping("/File/file")
public class FileController {
    @Autowired
    FileMapper fileMapper;
    @PostMapping("/update/{id}")
    public void updateFile(@PathVariable Integer id){
        File f = fileMapper.selectById(1);
        UpdateWrapper<File> update = new UpdateWrapper<>();
        update.eq("id", f.getId()).set("name", "test");
        fileMapper.update(null, update);
//        fileMapper.updateById(f);
        return;
    }
}
