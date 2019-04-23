package Dao.Util;

import database.UserInformationEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

import static database.Main.getSession;

public class LoginUtil {

    private Map<String,String> condition;

    public void setCondition(Map<String,String> condition) {
        this.condition = condition;
    }

    public String login(UserInformationEntity user) {
        System.out.println(user.getEmail()+" ,"+user.getPassword());
        final Session session = getSession();
//
        //1.创建CriteriaBuilder对象
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        //2.获取CriteriaQuery对象
        CriteriaQuery<UserInformationEntity> createQuery = criteriaBuilder.createQuery(UserInformationEntity.class);

        //3.指定根条件
        Root<UserInformationEntity> root = createQuery.from(UserInformationEntity.class);
        createQuery.where(criteriaBuilder.equal(root.get("email"), user.getEmail()));

        //4执行查询
        List<UserInformationEntity> List = session.createQuery(createQuery).getResultList();
        for (UserInformationEntity u : List) {
            System.out.println(u.getEmail()+"  "+u.getPassword());
            if (u.getPassword().equals(user.getPassword())) {
                System.out.println(user.getEmail() + " 登录成功");
                return "Success";
                //逻辑视图名       跳转页面默认为转发
            }
            return "Error";
        }

        return "Error";
    }

    public String register(UserInformationEntity userInformationEntity){
        final Session session = getSession();
//        Transaction tx = session.beginTransaction();
        //1.创建CriteriaBuilder对象
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        //2.获取CriteriaQuery对象
        CriteriaQuery<UserInformationEntity> createQuery = criteriaBuilder.createQuery(UserInformationEntity.class);

        //3.指定根条件
        Root<UserInformationEntity> root = createQuery.from(UserInformationEntity.class);
        createQuery.where(criteriaBuilder.equal(root.get("email"), userInformationEntity.getEmail()));

        //4执行查询
        List<UserInformationEntity> List = session.createQuery(createQuery).getResultList();

        if (List!=null){
            for (UserInformationEntity u : List) {
                if (u.getEmail()==userInformationEntity.getEmail()){
                    return "userExist";
                }
            }

        }
        Transaction tran = session.beginTransaction();

        UserInformationEntity u =new UserInformationEntity(userInformationEntity.getEmail(),userInformationEntity.getPassword());
        session.save(u);
        tran.commit();
        return "registerSuccess";
    }

    public String changePassword(UserInformationEntity userInformationEntity){
        final Session session = getSession();
//        Transaction tx = session.beginTransaction();
        //1.创建CriteriaBuilder对象
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        //2.获取CriteriaQuery对象
        CriteriaQuery<UserInformationEntity> createQuery = criteriaBuilder.createQuery(UserInformationEntity.class);

        //3.指定根条件
        Root<UserInformationEntity> root = createQuery.from(UserInformationEntity.class);
        createQuery.where(criteriaBuilder.equal(root.get("email"), userInformationEntity.getEmail()));
        List<UserInformationEntity> List = session.createQuery(createQuery).getResultList();
        for (UserInformationEntity u : List) {
            u.setPassword(userInformationEntity.getPassword());
            Transaction tran = session.beginTransaction();
            session.update(u);
            tran.commit();
        }
        return "changePasswordSuccess";
    }
    public List<UserInformationEntity> getList() {
        final Session session = getSession();
        //启用事务处理
//        Transaction tx = session.beginTransaction();

        //1.创建CriteriaBuilder对象
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        //2.获取CriteriaQuery对象
        CriteriaQuery<UserInformationEntity> createQuery = criteriaBuilder.createQuery(UserInformationEntity.class);

        //3.指定根条件
        Root<UserInformationEntity> root = createQuery.from(UserInformationEntity.class);
        try {
            createQuery.where(criteriaBuilder.equal(root.get(condition.get("refer")),condition.get("value")));
        } catch (ArrayIndexOutOfBoundsException ignore) {
        }

        //4执行查询
        List<UserInformationEntity> List = session.createQuery(createQuery).getResultList();

        session.close();
        return List;
    }
}
