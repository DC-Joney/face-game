package com.face.gmail.order.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.face.gamil.bean.user.UserAddress;
import com.face.gamil.service.UserAddressService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Reference
    private UserAddressService addressService;


    @RequestMapping("/trade")
    public List<UserAddress> trade(@RequestParam(value = "id",defaultValue = "root") String userId){
        return addressService.findUserAddressById(userId);
    }
}
