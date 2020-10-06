package club.banyuan.adminRoleRelation.dao;

import club.banyuan.adminRoleRelation.entity.UmsAdminRoleRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UmsAdminRoleRelationDao {
    int deleteByPrimaryKey(Long id);

    int insert(UmsAdminRoleRelation record);

    int insertSelective(UmsAdminRoleRelation record);

    UmsAdminRoleRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsAdminRoleRelation record);

    int updateByPrimaryKey(UmsAdminRoleRelation record);

    int deleteRole(Long adminId);

    int insertRole(@Param("adminId") Long adminId,@Param("roleId") Long roleId);

    List<Long> getRoleIdByAdminId(Long adminId);
}