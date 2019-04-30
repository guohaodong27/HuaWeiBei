package service;

import database.AchieveEntity;

import java.util.List;
import java.util.Map;

public interface ArticleService {

    //获取特定用户的文档
    List<AchieveEntity> getAchieve(Map<String,String> map);

    //保存文档
    void save(AchieveEntity achieve);

    //修改文档
    void modify(AchieveEntity achieve);

    //删除文档
    void delete(AchieveEntity achieve);
}
