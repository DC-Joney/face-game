package com.face.gamil.mapper;

import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.BaseMapper;

@RegisterMapper
public interface CrudSpreadMapper<T> extends InsertCollectionMapper<T>
        , BaseMapper<T> {
}
