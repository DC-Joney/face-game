package com.face.gamil.bean.manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

// 平台属性
@Data
@ApiModel("平台属性")
@ApiIgnore
public class BaseAttrInfo implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("平台属性id")
    private String id;


    @Column
    @ApiModelProperty("平台属性名称")
    private String attrName;

    //三级分类id
    @ApiModelProperty("三级分类id")
    @Column(name = "catalog3_Id")
    private String catalogId;

    @Transient
    private List<BaseAttrValue> attrInfo;

}

