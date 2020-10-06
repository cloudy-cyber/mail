package club.banyuan.admin.dao;

import club.banyuan.admin.entity.UmsAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminDao {
    UmsAdmin getUmsAdminByNameAndPwd(@Param("username") String username,@Param("password") String password);

    int deleteByPrimaryKey(Long id);

    int insert(UmsAdmin record);

    int insertSelective(UmsAdmin record);

    UmsAdmin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsAdmin record);

    int updateByPrimaryKey(UmsAdmin record);

    int updateStatus(@Param("status") Integer status,@Param("id") Long id);

    List<UmsAdmin> getAll();

    List<UmsAdmin> getAdminListByPage(@Param("keyword") String keyword,@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
}