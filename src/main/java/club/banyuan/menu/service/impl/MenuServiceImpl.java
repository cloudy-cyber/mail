package club.banyuan.menu.service.impl;

import club.banyuan.menu.dao.MenuDao;
import club.banyuan.menu.entity.Menu;
import club.banyuan.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;
    @Override
    public List<Menu> getAll() {
        return menuDao.getAll();
    }

    @Override
    public List<Menu> getMenuByPage(Long parentId, Integer pageNum, Integer pageSize) {
        return menuDao.getMenuByPage(parentId, pageNum, pageSize);
    }
}
