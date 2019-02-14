package com.face.gamil.bean.manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

//平台属性值
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "平台属性值")
public class BaseAttrValue implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("平台属性值id")
    private String id;


    @Column
    @ApiModelProperty("平台属性值名称")
    private String valueName;


    @Column
    @ApiModelProperty("平台属性id")
    private String attrId;


}

