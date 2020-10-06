package club.banyuan.menu.controller;

import club.banyuan.mall.mgt.dto.Message;
import club.banyuan.menu.entity.Menu;
import club.banyuan.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/list/{parentId}")
    @ResponseBody
    public Message getMenuListByPage(@PathVariable("parentId") Long parentId, Integer pageNum, Integer pageSize) {
        List<Menu> all = menuService.getAll();
        List<Menu> getMenuByPage = menuService.getMenuByPage(parentId, pageNum, pageSize);
        Message message = new Message();
        Map<String, Object> map = new HashMap<>();
        map.put("list", getMenuByPage);
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        map.put("total", all.size());
        map.put("totalPage", (all.size() / 10) + 1);
        message.setCode(200);
        message.setMessage("成功");
        message.setData(map);
        return message;
    }

}
