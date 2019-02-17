package com.face.gamil.service;

import com.face.gamil.bean.spu.BaseSaleAttr;
import com.face.gamil.bean.spu.SpuInfo;

import java.util.List;

public interface SpuService {

    List<SpuInfo> getSpuInfoList(String catalog3Id);

    void saveSpuInfo(SpuInfo spuInfo);


    /**
     * 获取所有的销售属性字典表
     * @return
     */

    List<BaseSaleAttr> getAllBaseSaleAttr();

}
