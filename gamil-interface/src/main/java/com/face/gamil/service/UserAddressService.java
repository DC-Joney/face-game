package com.face.gamil.service;

import com.face.gamil.bean.user.UserAddress;

import java.util.List;

public interface UserAddressService {

    List<UserAddress> findUserAddressById(String userId);


}
