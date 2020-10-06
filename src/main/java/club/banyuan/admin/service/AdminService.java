package club.banyuan.admin.service;

import club.banyuan.admin.entity.UmsAdmin;
import club.banyuan.role.entity.Role;

import java.util.List;

public interface AdminService {
    UmsAdmin login(String name,String password);

    List<UmsAdmin> getAll();

    List<UmsAdmin> getAdminByPage(String keyword,int pageNum,int pageSize);

    void addAdmin(UmsAdmin admin);

    void deleteAdminById(Long id);

    void updateAdmin(UmsAdmin umsAdmin);

    void updateStatus(Integer status,Long id);

    UmsAdmin getAdminById(Long id);

    List<Role> getRoleListByAdminId(Long adminId);

}
