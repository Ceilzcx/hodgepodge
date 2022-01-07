package com.siesta.hodgepodge.dubbo.producer.impl;

import com.siesta.hodgepodge.dubbo.entity.Role;
import com.siesta.hodgepodge.dubbo.service.IRoleService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@DubboService(version = "1.0.0")
@Service
public class RoleService implements IRoleService {

    @Override
    public List<Role> getUserRoles(String userId) {
        List<Role> roles = new ArrayList<>();
        Role role = new Role();
        if (userId.equals("admin")) {
            role.setRoleName("admin");
        } else {
            role.setRoleName("common");
        }
        roles.add(role);
        return roles;
    }

}
