package com.app.controller;

import com.app.pojo.User;
import com.app.pojo.UserExample;
import com.app.service.UserService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by heqiyan on 2016/12/5.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findUser")
    public ModelAndView findUser() throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        List<User> users = userService.findUser();

        modelAndView.addObject("users", users);

        modelAndView.setViewName("findUser");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/userList")
    public Object userList(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String page = request.getParameter("page");
        String rows = request.getParameter("rows");

        Map<String, Object> result = new HashMap<String, Object>();

   //     List<User> list = usermMapper.selectByExample(ue);
//        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));

//        List<User> users = userService.findUser();

        UserExample userExample = new UserExample();

        List<User> list = userService.findUserByPage(page, rows ,userExample);

        PageInfo<User> pageInfo = new PageInfo<User>(list);
        List<User> users = pageInfo.getList();
        JSONArray jsonArray = new JSONArray();

        for (User user : users) {
        	JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",user.getId()) ;
            jsonObject.put("firstname",user.getFirstname());
            jsonObject.put("lastname", user.getLastname());
            jsonObject.put("phone",user.getPhone());
            jsonObject.put("email", user.getEmail());
            jsonArray.add(jsonObject);
        }
        result.put("total", pageInfo.getTotal());
        result.put("rows",jsonArray);

        return JSONObject.fromObject(result);

    }

    @ResponseBody
    @RequestMapping("/saveUser")
    public Object saveUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        String id = request.getParameter("id");

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        User user = new User();
        if(id!=null) {
            user.setId(Integer.parseInt(id));
        }
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setPhone(phone);
        user.setEmail(email);
        int flag = 0;

        if(null ==id || "".equals(id)) {
            flag  =  userService.saveUser(user);
        } else {
            flag = userService.modifyUser(user);
        }

        if(flag == 0) {
            result.put("msg","Some errors occured.");
            return JSONObject.fromObject(result);
        }
        result.put("success",true);
        return JSONObject.fromObject(result);

    }

    @ResponseBody
    @RequestMapping("/deleteUser")
    public Object deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        String id = request.getParameter("id");
        int flag = 0;
        flag =  userService.deleteUser(Integer.parseInt(id));

        if(flag == 0) {
            result.put("msg","Some errors occured.");
            return JSONObject.fromObject(result);
        }
        result.put("success",true);
        return JSONObject.fromObject(result);
    }

    @ResponseBody
    @RequestMapping("/test")
    public Object test(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();

        result.put("aa","asdfasdfasdfasfffffffff");

        return JSONObject.fromObject(result);
    }





}
