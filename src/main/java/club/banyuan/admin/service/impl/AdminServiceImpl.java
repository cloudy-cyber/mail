package club.banyuan.admin.service.impl;

import club.banyuan.admin.dao.AdminDao;
import club.banyuan.admin.entity.UmsAdmin;
import club.banyuan.admin.service.AdminService;
import club.banyuan.adminRoleRelation.dao.UmsAdminRoleRelationDao;
import club.banyuan.role.dao.RoleDao;
import club.banyuan.role.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private UmsAdminRoleRelationDao umsAdminRoleRelationDao;
    @Autowired
    private RoleDao roleDao;
    @Override
    public UmsAdmin login(String name, String password) {
        UmsAdmin umsAdmin = adminDao.getUmsAdminByNameAndPwd(name,password);
        return umsAdmin;
    }

    @Override
    public List<UmsAdmin> getAll() {
        return adminDao.getAll();
    }

    @Override
    public List<UmsAdmin> getAdminByPage(String keyword,int pageNum, int pageSize) {
        System.out.println(keyword);
        System.out.println(pageNum);
        System.out.println(pageSize);
        return adminDao.getAdminListByPage(keyword,pageNum, pageSize);
    }

    @Override
    public void addAdmin(UmsAdmin admin) {
        adminDao.insertSelective(admin);
    }

    @Override
    public void deleteAdminById(Long id) {
        adminDao.deleteByPrimaryKey(id);
    }

    @Override
    public void updateAdmin(UmsAdmin umsAdmin) {
        adminDao.updateByPrimaryKeySelective(umsAdmin);
    }

    @Override
    public void updateStatus(Integer status, Long id) {
        adminDao.updateStatus(status,id);
    }

    @Override
    public UmsAdmin getAdminById(Long id) {
        return adminDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Role> getRoleListByAdminId(Long adminId) {
        List<Long> roleIdByAdminId = umsAdminRoleRelationDao.getRoleIdByAdminId(adminId);
        List<Role> roleList = new ArrayList<>();
        Role role = new Role();
        for (Long roleId : roleIdByAdminId) {
            role = roleDao.selectByPrimaryKey(roleId);
            roleList.add(role);
        }
        return roleList;
    }
}
