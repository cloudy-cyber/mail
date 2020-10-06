package club.banyuan.role.controller;

import club.banyuan.mall.mgt.dto.Message;
import club.banyuan.role.entity.Role;
import club.banyuan.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    @ResponseBody
    public Message getRoleByPage(String keyword, Integer pageSize, Integer pageNum) {
        Message message = new Message();
        Map<String, Object> map = new HashMap<>();
        List<Role> roleList = roleService.getRoleByPage(keyword, (pageNum - 1) * pageSize,pageSize);
        System.out.println("=======================================");
        System.out.println(roleList);
        System.out.println("====================================");
        List<Role> allRole = roleService.getAll();
        System.out.println(allRole);
        map.put("list",roleList);
        map.put("pageNum",pageNum);
        map.put("pageSize",pageSize);
        map.put("total",allRole.size());
        map.put("totalPage",(allRole.size()/10)-1);
        message.setCode(200);
        message.setData(map);
        message.setMessage("列表");
        return message;
    }

    @RequestMapping("/listAll")
    @ResponseBody
    public Message getAll() {
        Message message = new Message();
        List<Role> all = roleService.getAll();
        message.setCode(200);
        message.setData(all);
        message.setMessage("所有角色列表");
        return message;
    }
    @RequestMapping("/create")
    @ResponseBody
    public Message addRole(@RequestBody Role role){
        roleService.addRole(role);
        Message message = new Message();
        message.setCode(200);
        message.setMessage("添加成功");
        return message;
    }
    @RequestMapping("/delete")
    @ResponseBody
    public Message deleteRole(Long[] ids){
        roleService.deleteRole(ids);
        Message message = new Message();
        message.setCode(200);
        message.setMessage("删除成功");
        return message;
    }
    @RequestMapping("/update/{id}")
    @ResponseBody
    public Message updateRole(@RequestBody Role role,@PathVariable("id") Long id){
        roleService.updateRole(role);
        Message message = new Message();
        message.setCode(200);
        message.setMessage("修改成功");
        return message;
    }
    @RequestMapping("/updateStatus/{id}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") Long id,Integer status){
        roleService.updateStatus(id, status);
        Message message = new Message();
        message.setCode(200);
        message.setMessage("修改状态成功");
        return message;
    }

}
