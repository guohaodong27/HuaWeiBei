package controller;

import com.google.gson.Gson;
import database.AchieveEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import static database.Main.getSession;

@Controller
@RequestMapping(value = "/article" ,produces = "application/json;charset=UTF-8")
public class GetArticle {
    //获取列表
    @RequestMapping("/fetchAll{userId}")
//    @ResponseBody
    public String fetchAll(Model model, @PathVariable String userId) {
        final Session session = getSession();
//        Transaction tx = session.beginTransaction();

        //1.创建CriteriaBuilder对象
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        //2.获取CriteriaQuery对象
        CriteriaQuery<AchieveEntity> createQuery = criteriaBuilder.createQuery(AchieveEntity.class);

        //3.指定根条件
        Root<AchieveEntity> root = createQuery.from(AchieveEntity.class);
        createQuery.where(criteriaBuilder.equal(root.get("userId"),userId));

        //4执行查询
        List<AchieveEntity> List = session.createQuery(createQuery).getResultList();

        //5.转换为json
        Gson gson = new Gson();
        System.out.println(gson.toJson(List));
        model.addAttribute("usersList",gson.toJson(List));
        return "fetchAll";
    }

    //获取特定标签内容
    @RequestMapping("fetchTag/${tag}")
    @ResponseBody
    public String fetchTag(@PathVariable String tag) {

        return "";
    }
}

