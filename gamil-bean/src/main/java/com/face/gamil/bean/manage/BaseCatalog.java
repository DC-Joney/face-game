package com.face.gamil.bean.manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.entity.IDynamicTableName;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

//分类表
@Data
@ApiModel(value = "首页分类", description = "首页导航分类")
@Table(name = "base_catalog")
public class BaseCatalog implements Serializable, IDynamicTableName {

    @Id
    @Column
    private String id;

    @Column
    @ApiModelProperty("分类名称")
    private String name;

    @Column(name = "parentId")
    @ApiModelProperty("分类父ID")
    private String parentId;

    //声明非数据库字段
    @Transient
    private String tableName;

    @Override
    public String getDynamicTableName() {
        return tableName;
    }
}
