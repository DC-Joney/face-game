package com.face.gamil.manager.service.impl;


import com.face.gamil.bean.spu.BaseSaleAttr;
import com.face.gamil.bean.spu.SpuInfo;
import com.face.gamil.bean.spu.SpuSaleAttrValue;
import com.face.gamil.manager.mapper.BaseSaleAttrDao;
import com.face.gamil.manager.mapper.spu.SpuImageDao;
import com.face.gamil.manager.mapper.spu.SpuInfoDao;
import com.face.gamil.manager.mapper.spu.SpuSaleAttrDao;
import com.face.gamil.manager.mapper.spu.SpuSaleAttrValueDao;
import com.face.gamil.service.SpuService;
import com.face.gamil.service.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@DubboService
public class SpuServiceImpl implements SpuService {

    @Autowired
    private SpuInfoDao spuInfoDao;


    @Autowired
    private BaseSaleAttrDao baseSaleAttrDao;

    @Autowired
    private SpuSaleAttrDao spuSaleAttrDao;

    @Autowired
    private SpuImageDao spuImageDao;

    @Autowired
    private SpuSaleAttrValueDao spuSaleAttrValueDao;

    @Override
    public List<SpuInfo> getSpuInfoList(String catalog3Id) {

        Example example = Example.builder(SpuInfo.class)
                .andWhere(Sqls.custom().andEqualTo("catalogId", catalog3Id)).build();

        return spuInfoDao.selectByExample(example);
    }

    @Override
    public void saveSpuInfo(SpuInfo info) {

        Optional.ofNullable(info).ifPresent(spuInfo -> {

            Optional.ofNullable(spuInfo.getId()).filter(StringUtils::isEmpty).ifPresent(id -> spuInfo.setId(null));

            spuInfoDao.insertSelective(spuInfo);

            Optional.ofNullable(spuInfo.getSpuSaleAttrList())
                    .filter(attrList -> !CollectionUtils.isEmpty(attrList))
                    .map(attrList -> attrList.parallelStream().peek(spuSaleAttr -> {
                                spuSaleAttr.setId(spuInfo.getId());

                                Optional.ofNullable(spuSaleAttr.getSpuSaleAttrValueList())
                                        .filter(valueList -> !CollectionUtils.isEmpty(valueList))
                                        .map(attrValues -> attrValues.stream().peek(spuSaleAttrValue -> spuSaleAttrValue.setSpuId(spuInfo.getId())).collect(Collectors.toList()))
                                        .ifPresent(attrValues -> spuSaleAttrValueDao.insertCollectionSelective(attrValues));

                            }).collect(Collectors.toList())
                    )
                    .ifPresent(attrList -> spuSaleAttrDao.insertCollectionSelective(attrList));

            Optional.ofNullable(spuInfo.getSpuImageList())
                    .filter(imageList -> !CollectionUtils.isEmpty(imageList))
                    .map(attrList -> attrList.stream().peek(spuSaleAttr -> spuSaleAttr.setId(spuInfo.getId())).collect(Collectors.toList()))
                    .ifPresent(attrList -> spuImageDao.insertCollectionSelective(attrList));

        });

    }

    @Override
    public List<BaseSaleAttr> getAllBaseSaleAttr() {
        return baseSaleAttrDao.selectAll();
    }


}
