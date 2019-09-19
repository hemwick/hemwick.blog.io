package com.pujiang.blog.controller.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pujiang.blog.bean.User;
import com.pujiang.blog.service.UserService;
import com.pujiang.blog.util.ResBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getPage")
    public ResBean getPage(int offset, int limit, User user){
        return userService.getPage(offset,limit,user);
    }
    @RequestMapping("/getAll")
    public List<User> getAll(){
        return userService.getAll();
    }

    @RequestMapping("/delete")
    public ResBean deleteById(Integer id){
        return userService.deleteById(id);
    }
    @RequestMapping("/getById")
    public User getById(Integer id){
        System.out.println(id);
        return userService.getById(id);
    }
    @RequestMapping("/saveInfo")
    public ResBean saveInfo(User user){
        return userService.saveInfo(user);
    }

    /*@RequestMapping("/checkName")
    public String checkNameValidMethod1(@RequestParam String name) {
        boolean result = true;
        List<User> userList = userService.getAll();
        for (User user : userList) {
            if (user.getUsername().equals(name)) {
                result = false;
                break;
            }
        }
        Map<String, Boolean> map = new HashMap<>();
        map.put("valid", result);
        ObjectMapper mapper = new ObjectMapper();
        String resultString = "";
        try {
            resultString = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(resultString);
        return resultString;
    }
*/

                        public static void main(String[] args){
                            int count = 0;
                            for (int i = 0; i < 10; i++){
                                count = count ++;
                            }
                            System.out.print("count:"+count);
                        }

}
