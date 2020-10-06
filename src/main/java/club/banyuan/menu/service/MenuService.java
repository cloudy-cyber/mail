package club.banyuan.menu.service;

import club.banyuan.menu.entity.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getAll();

    List<Menu> getMenuByPage(Long parentId,Integer pageNum,Integer pageSize);
}
