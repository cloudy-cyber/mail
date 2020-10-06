package club.banyuan.adminRoleRelation.service.impl;

import club.banyuan.adminRoleRelation.dao.UmsAdminRoleRelationDao;
import club.banyuan.adminRoleRelation.service.AdminRoleRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminRoleRelationServiceImpl implements AdminRoleRelationService {
    @Autowired
    private UmsAdminRoleRelationDao umsAdminRoleRelationDao;
    @Override
    public void updateAdminRole(Long adminId, Long[] roleIds) {
        umsAdminRoleRelationDao.deleteRole(adminId);
        for (Long roleId : roleIds) {
            umsAdminRoleRelationDao.insertRole(adminId,roleId);
        }
    }
}
