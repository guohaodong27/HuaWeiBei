package controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonSyntaxException;
import database.AchieveEntity;
import implement.ArticleImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.ArticleService;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/article" ,produces = "application/json;charset=UTF-8")
public class GetArticle {

    private ArticleService service = new ArticleImpl();
    private Gson gson = new Gson();

    //获取列表
    @RequestMapping("/fetchAll")
    @ResponseBody
    public String fetchAll(@RequestBody String userId) {

        Map<String,String> condition = new HashMap<>(1);
        condition = gson.fromJson(userId,condition.getClass());
//        condition.put("userId",userId);

        return gson.toJson(service.getAchieve(condition));
    }

    //获取特定标签内容
    @RequestMapping("/fetchTag")
    @ResponseBody
    public String fetchTag(@RequestBody String Json) {

        Map<String,String> condition = new HashMap<>(2);
        condition = gson.fromJson(Json,condition.getClass());
        String json = gson.toJson(service.getAchieve(condition));
        return gson.toJson(json);
    }

    //保存
    @RequestMapping("/save")
    @ResponseBody
    public String save(@RequestBody String achieve){
        try {
            service.save(gson.fromJson(achieve,AchieveEntity.class));
        } catch (JsonSyntaxException e) {
            return "1";
        }
        return "0";
    }

    //删除
    @RequestMapping("delete")
    @ResponseBody
    public String delete(@RequestBody String achieve){
        try {
            service.delete(gson.fromJson(achieve,AchieveEntity.class));
        } catch (JsonSyntaxException e) {
            return "1";
        }
        return "0";
    }
}

