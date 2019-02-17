package com.face.gamil.mapper;

import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;

@RegisterMapper
public interface CrudSpreadMapper<T> extends InsertCollectionMapper<T>
        , Mapper<T> {
}
