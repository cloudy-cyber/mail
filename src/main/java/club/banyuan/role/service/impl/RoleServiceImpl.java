package club.banyuan.role.service.impl;

import club.banyuan.role.dao.RoleDao;
import club.banyuan.role.entity.Role;
import club.banyuan.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> getAll() {
        return roleDao.getAll();
    }

    @Override
    public List<Role> getRoleByPage(String keyword, Integer pageNum, Integer pageSize) {
        return roleDao.getListByPage(keyword, pageNum, pageSize);
    }

    @Override
    public void addRole(Role role) {
        roleDao.insertSelective(role);
    }

    @Override
    public void deleteRole(Long[] ids) {
        for (Long id : ids) {
            roleDao.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void updateRole(Role role) {
        roleDao.updateByPrimaryKeySelective(role);
    }

    @Override
    public void updateStatus(Long id, Integer status) {
        roleDao.updateStatus(id, status);
    }
}
