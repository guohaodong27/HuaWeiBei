package controller;

import Dao.Util.LoginUtil;
import com.google.gson.Gson;
import database.UserInformationEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DELL
 */
@Controller
@RequestMapping(value = "/user",produces = "application/json;charset=UTF-8")
public class Login {

    @RequestMapping(value = "/login",produces = "json/application;charset=UTF-8")
    @ResponseBody
    public String login(@RequestBody String json) {
        System.out.println("11");
        Gson gson = new Gson();
        UserInformationEntity userInformationEntity = gson.fromJson(json, UserInformationEntity.class);
//        LoginUtil loginUtil = new LoginUtil();
//        System.out.println(loginUtil.login(userInformationEntity));
        UserInformationEntity data = LoginUtil.getUser(userInformationEntity).get(0);
        if(data.getPassword().equals(userInformationEntity.getPassword())){
            return gson.toJson(data);
        }
        else{
            return "null";
        }
    }


    @RequestMapping(value = "/register",produces = "json/application;charset=UTF-8")
    @ResponseBody
    public String register(@RequestBody String json){
        Gson gson = new Gson();
        UserInformationEntity userInformationEntity = gson.fromJson(json, UserInformationEntity.class);
        LoginUtil loginUtil = new LoginUtil();
        return gson.toJson(loginUtil.register(userInformationEntity));
    }

    @RequestMapping(value = "/changePassword",produces = "json/application;charset=UTF-8")
    public String changePassword(@RequestBody String json) {
        Gson gson = new Gson();
        UserInformationEntity userInformationEntity = gson.fromJson(json, UserInformationEntity.class);
        LoginUtil loginUtil = new LoginUtil();
        return gson.toJson(loginUtil.changePassword(userInformationEntity));
    }

    @RequestMapping("/getById")

    public String getById(@RequestBody String json) {
        Gson gson = new Gson();
        UserInformationEntity userInformationEntity = gson.fromJson(json, UserInformationEntity.class);
        Map<String,String> map = new HashMap<>(2);
        map.put("refer","id");
        map.put("value",userInformationEntity.getId());
        LoginUtil loginUtil =new LoginUtil();
        loginUtil.setCondition(map);
        List<UserInformationEntity> list = loginUtil.getList();
        String result = gson.toJson(list);
        System.out.println(result);
        return result;
    }
}
