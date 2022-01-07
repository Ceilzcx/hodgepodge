package com.siesta.hodgepodge.dubbo.service;

import com.siesta.hodgepodge.dubbo.entity.Role;

import java.util.List;

public interface IRoleService {

    List<Role> getUserRoles(String userId);

}
