package com.maxeluds.hroauth.services;

import com.maxeluds.hroauth.entities.User;
import com.maxeluds.hroauth.feignclients.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        var user = userFeignClient.findByEmail(email).getBody();

        if(user == null) {
            throw new IllegalArgumentException("Usuário não encontrado!");
        }

        return user;
    }
}
