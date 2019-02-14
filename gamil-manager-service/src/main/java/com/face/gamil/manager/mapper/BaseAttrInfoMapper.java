package com.face.gamil.manager.mapper;

import com.face.gamil.bean.manage.BaseAttrInfo;
import com.face.gamil.mapper.CrudSpreadMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@CacheNamespace
public interface BaseAttrInfoMapper extends CrudSpreadMapper<BaseAttrInfo> {

    @Transactional
    @Results(
            id = "BaseAttrInfo",
            value = {
                    @Result(property = "id",column = "id"),
                    @Result(property = "attrName",column = "attr_Name"),
                    @Result(property = "catalogId",column = "catalog3_Id"),
                    @Result(property = "attrInfo",column="id",many = @Many(
                            select = "com.face.gamil.manager.mapper.BaseAttrValueMapper.selectByAttrId"
                    )),
            }
    )
    @Select("SELECT * FROM base_attr_info where catalog3_id = #{catalogId}")
    List<BaseAttrInfo> selectById(@Param("catalogId") String id);


//    @InsertProvider()
//    List<BaseAttrInfo> selectById(@Param("catalogId") String id);


}

