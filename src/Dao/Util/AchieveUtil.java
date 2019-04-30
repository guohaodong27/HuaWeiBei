package Dao.Util;

import com.google.gson.Gson;
import database.AchieveEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.*;

import static database.Main.getSession;

public class AchieveUtil {
    //查询
    public static List<AchieveEntity> getAchieve(Map<String,String> condition){
        final Session session = getSession();
//        Transaction tx = session.beginTransaction();

        //1.创建CriteriaBuilder对象
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        //2.获取CriteriaQuery对象
        CriteriaQuery<AchieveEntity> createQuery = criteriaBuilder.createQuery(AchieveEntity.class);

        //3.指定根条件
        Root<AchieveEntity> root = createQuery.from(AchieveEntity.class);

        //获取用户id
        if(condition.containsKey("userId")) {
            createQuery.where((criteriaBuilder.equal(root.get("userId"), Integer.valueOf(condition.get("userId")))));
            condition.remove("userId");
        }
        if(condition.containsKey("achieveId")){
            createQuery.where((criteriaBuilder.equal(root.get("achieveId"), Integer.valueOf(condition.get("achievedId")))));
            condition.remove("achieveId");
        }

        Set<String> keySet = condition.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            createQuery.where(criteriaBuilder.equal(root.get(key),condition.get(key)));
        }

        //4执行查询
        List<AchieveEntity> List = session.createQuery(createQuery).getResultList();
        session.close();

        return List;
    }

    //保存
    public static void save(AchieveEntity achieve){
        final Session session = getSession();
        //事务处理
        Transaction tx = session.beginTransaction();
        session.save(achieve);
        tx.commit();
        session.close();
    }

    //删除
    public static void delete(AchieveEntity achieveEntity){
        final Session session = getSession();
        //事务处理
        Transaction tx = session.beginTransaction();
        Map<String,String> map = new HashMap<>(1);
        map.put("achieveId", String.valueOf(achieveEntity.getAchieveId()));
        session.delete(getAchieve(map).get(0));
        tx.commit();
        session.close();
    }
}
