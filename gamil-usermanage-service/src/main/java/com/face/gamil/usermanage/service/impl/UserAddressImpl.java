package com.face.gamil.usermanage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.face.gamil.bean.user.UserAddress;
import com.face.gamil.service.UserAddressService;
import com.face.gamil.usermanage.mapper.UserAddressMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Log4j2
@Component
@Service(interfaceClass = UserAddressService.class)
public class UserAddressImpl implements UserAddressService {

    @Autowired
    private UserAddressMapper userAddressMapper;

    @Override
    public List<UserAddress> findUserAddressById(String userId) {
        log.info("############################正在消费。。。");
        return userAddressMapper.select(UserAddress.of(userId));
    }
}
