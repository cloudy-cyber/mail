package club.banyuan.role.service;

import club.banyuan.role.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAll();

    List<Role> getRoleByPage(String keyword,Integer pageNum,Integer pageSize);

    void addRole (Role role);

    void deleteRole(Long[] ids);

    void updateRole(Role role);

    void updateStatus(Long id,Integer status);
}
