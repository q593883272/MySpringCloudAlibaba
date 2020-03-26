package com.raven.cloud.provider.resource.service;

import com.alibaba.fastjson.JSON;
import com.raven.cloud.provider.resource.dao.ImageDao;
import com.raven.cloud.provider.resource.entity.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By Raven on 2020/2/21 14:33
 */
@RestController
@RequestMapping({"/resource"})
public class ResourceProviderService {

    @Autowired
    private ImageDao imageDao;

    @GetMapping("/image/find")
    public String findImage(@RequestParam(value = "id", required = false) Long id, @RequestParam(value = "name", required = false) String name) {
        Example<Image> ex = Example.of(new Image().setId(id).setName(name));
        return JSON.toJSONString(imageDao.findAll(ex));
    }

    @Transactional
    @GetMapping("/image/add")
    public String addImage(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "path", required = false) String path) {
        return JSON.toJSONString(imageDao.save(new Image().setName(name).setFilePath(path)));
    }

}
