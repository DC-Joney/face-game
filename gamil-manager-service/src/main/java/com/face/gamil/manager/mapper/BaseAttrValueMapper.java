package com.face.gamil.manager.mapper;

import com.face.gamil.bean.manage.BaseAttrValue;
import com.face.gamil.mapper.CrudSpreadMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BaseAttrValueMapper extends CrudSpreadMapper<BaseAttrValue> {

  /*  @Results(
            id = "BaseAttrValueMap",
            value = {
                    @Result(property = "id",column = "id"),
                    @Result(property = "valueName",column = "value_Name"),
                    @Result(property = "attrId",column = "attr_id")
            }
    )*/
    @Select("SELECT * FROM base_attr_value where attr_Id = #{id}")
    List<BaseAttrValue> selectByAttrId(@Param("id") String id);


}

