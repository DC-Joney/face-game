package com.face.gamil.service;

import com.face.gamil.bean.manage.BaseAttrInfo;
import com.face.gamil.bean.manage.BaseCatalog;

import java.util.List;

public interface ManagerService {

    //查询所有一级分类
    List<BaseCatalog> getCatalog();

    //查询所有二级分类、三级分类
    List<BaseCatalog> getCatalogByParentId(String tableName, String parentId);


    //根据三级分类id 查询平台属性所有数据
    List<BaseAttrInfo> getAttrList(String catalogId);


    //添加平台属性
    void saveBaseAttrInfo(BaseAttrInfo baseAttrInfo);

}
