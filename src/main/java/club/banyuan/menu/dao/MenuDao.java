package club.banyuan.menu.dao;

import club.banyuan.menu.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDao {
    int deleteByPrimaryKey(Long id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> getAll();

    List<Menu> getMenuByPage(@Param("parentId") Long parentId, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
}