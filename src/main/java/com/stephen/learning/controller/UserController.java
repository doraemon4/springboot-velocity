package com.stephen.learning.controller;

import com.alibaba.fastjson.JSON;
import com.stephen.learning.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: jack
 * @Date: 2018/11/8 11:49
 * @Description:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 模拟数据源
     *
     * @return
     */
    private List<User> createUsers() {
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 100; i++) {
            User user = User.builder().name("user" + i).sex("male").age((int) (Math.random() * 10 + 20)).email("23232443@qq.com").build();
            users.add(user);
        }
        return users;
    }

    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    public ModelAndView queryAllUser() {
        List<User> users = createUsers();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "查询用户列表");
        map.put("userList", users);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addAllObjects(map);

        return modelAndView;
    }

    @RequestMapping(value = "/queryAllPager", method = RequestMethod.GET)
    public ModelAndView queryAllUser2() {
        List<User> users = createUsers();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "查询用户列表");
        map.put("userList",JSON.toJSONString(users));

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index2");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }
}
