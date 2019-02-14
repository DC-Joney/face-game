package com.face.gamil.usermanage.service.impl;

import com.face.gamil.bean.user.UserInfo;
import com.face.gamil.service.UserInfoService;
import com.face.gamil.usermanage.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> findAll() {
        return userInfoMapper.selectAll();
    }
}
