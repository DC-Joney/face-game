package com.face.gamil.mapper;

import com.face.gamil.mapper.provider.InsertCollectionProvider;
import org.apache.ibatis.annotations.InsertProvider;
import tk.mybatis.mapper.annotation.RegisterMapper;

import java.util.List;

@RegisterMapper
public interface InsertCollectionMapper<T> {

    @InsertProvider(type = InsertCollectionProvider.class, method = "dynamicSQL")
    int insertCollectionSelective(List<T> list);

}
