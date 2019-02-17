package com.face.gmail.manage.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.face.gamil.bean.spu.SpuInfo;
import com.face.gamil.service.SpuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 处理Spuinfo信息
 * spu 基本信息 商品名称 和 描述
 *     spuImage 图片url和地址
 *     spuSaleAttr（销售属性） 销售属性的添加是从BaseSaleAttr(销售属性字典中)选取添加的信息
 *          -spuSaleAttrValue（销售属性值）
 */

@Api("spu web接口")
@RestController
@RequestMapping("/spu")
public class SpuManageController {

    @Reference
    private SpuService spuService;

    @ApiOperation("根据三级分类Id获取所有的spuinfo 列表")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query",required = true,dataType = "string",name = "catalogId",value = "查询spu info列表所需要的id"),
    })
    @GetMapping("/list")
    public List<SpuInfo> findSpuInfoList(String catalogId){
        return spuService.getSpuInfoList(catalogId);
    }

    @ApiOperation("根据三级分类添加spuinfo 信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body",required = true,dataTypeClass = SpuInfo.class,name = "spuInfo",value = "需要保存的SpuInfo信息"),
    })
    @GetMapping("/searchSpuInfo")
    public SpuInfo searchSpuInfo(SpuInfo spuInfo){
        spuService.saveSpuInfo(spuInfo);
        return null;
    }


    @ApiOperation("根据三级分类添加spuinfo 信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body",required = true,dataTypeClass = SpuInfo.class,name = "spuInfo",value = "需要保存的SpuInfo信息"),
    })
    @GetMapping("/save")
    public String saveSupInfo(SpuInfo spuInfo){
         spuService.saveSpuInfo(spuInfo);
         return "SUCCESS";
    }


}
