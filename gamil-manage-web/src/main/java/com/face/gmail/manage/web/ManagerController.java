package com.face.gmail.manage.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.face.gamil.bean.manage.BaseAttrInfo;
import com.face.gamil.bean.manage.BaseAttrValue;
import com.face.gamil.bean.manage.BaseCatalog;
import com.face.gamil.service.ManagerService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "平台web层",produces = "平台消费服务")
@RestController
public class ManagerController {

    @Reference
    private ManagerService managerService;

    @ApiOperation("查询最顶层分类表")
    @GetMapping("/getCatalog")
    public List<BaseCatalog> getTopLevelCatalog(){
        return managerService.getCatalog();
    }

//    @ApiParam 针对的是body
    //ApiImplicitParam 针对的是query

    @ApiOperation("查询二级或者三级分类,根据父分类id进行查询")
    @ApiResponses({
                    @ApiResponse(code = 200,message = "访问成功"),
                    @ApiResponse(code = 400,message = "访问参数又问题")
            })
    @ApiImplicitParams({
                    @ApiImplicitParam(paramType = "query",required = true,dataType = "int",name = "level",value = "需要查询的分类级别"),
                    @ApiImplicitParam(paramType = "query",required = true,dataType = "string",name = "parentId",value = "需要查询的分类父ID")
            })
    @GetMapping("/getCatalogChild")
    public List<BaseCatalog> getCatalog(Integer level,String parentId){

        if(ManageLevel.matches(level)){

            ManageLevel manageLevel = ManageLevel.resolve(level);

            return managerService.getCatalogByParentId(manageLevel.getTableName(),parentId);

        }

        return null;
    }

    @ApiOperation("获取分类级别中所有的平台属性")
    @ApiResponses({
            @ApiResponse(code = 200,message = "访问成功"),
            @ApiResponse(code = 400,message = "访问参数又问题")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",required = true,dataType = "String",name = "catalogId",value = "需要查询的分类级别ID"),
    })
    @GetMapping("/getAllAttrInfo")
    public List<BaseAttrInfo> getCatalog(String catalogId){
       return managerService.getAttrList(catalogId);
    }


    @ApiOperation("添加平台属性")
    @ApiResponses({
            @ApiResponse(code = 200,message = "添加成功"),
            @ApiResponse(code = 400,message = "访问参数又问题")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body",required = true,dataTypeClass = BaseAttrInfo.class,name = "baseAttrInfo",value = "平台属性,依据catalog3_id"),
    })
    @PostMapping("/saveAttrInfo")
    public String saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo){
        managerService.saveBaseAttrInfo(baseAttrInfo);
        return "SUCCESS";
    }


    @ApiOperation("查询单个平台属性（内含所有的平台属性值）")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",required = true,dataTypeClass = String.class,name = "attrInfoId",value = "平台属性id"),
    })
    @GetMapping("/getAttrInfo")
    public BaseAttrInfo getAttrInfo(String attrInfoId){
//        managerService.saveBaseAttrInfo(baseAttrInfo);
        return null;
    }



    @ApiOperation("根据平台属性ID 查找平台属性下所有的属性值")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",required = true,dataTypeClass = String.class,name = "attrInfoId",value = "平台属性id"),
    })
    @GetMapping("/")
    public String getAttrValues(String attrInfoId){
//        managerService.saveBaseAttrInfo(baseAttrInfo);
        return "SUCCESS";
    }


    @ApiOperation("根据平台属性ID 添加平台属性值")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body",required = true,dataTypeClass = BaseAttrValue.class,name = "baseAttrValue",value = "平台属性值,依赖平台属性ID"),
    })
    @PostMapping("/saveAttrValue")
    public String saveAttrValue(BaseAttrValue baseAttrValue){
//        managerService.saveBaseAttrInfo(baseAttrInfo);
        return "SUCCESS";
    }

    @ApiOperation("根据属性值ID 删除平台属性值")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body",required = true,dataTypeClass = String.class,name = "attrValueId",value = "平台属性值id"),
    })
    @PostMapping("/deleteAttrValue")
    public String deleteAttrValue(String attrValueId){
//        managerService.saveBaseAttrInfo(baseAttrInfo);
        return "SUCCESS";
    }


}
