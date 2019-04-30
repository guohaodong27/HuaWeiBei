package implement;

import Dao.Util.AchieveUtil;
import database.AchieveEntity;
import service.ArticleService;

import java.util.List;
import java.util.Map;

public class ArticleImpl implements ArticleService {
    @Override
    public List<AchieveEntity> getAchieve(Map<String,String> condition) {
        return AchieveUtil.getAchieve(condition);
    }

    @Override
    public void save(AchieveEntity achieve) {
        AchieveUtil.save(achieve);
    }

    @Override
    public void modify(AchieveEntity achieve) {
        AchieveUtil.delete(achieve);
        AchieveUtil.save(achieve);
    }

    @Override
    public void delete(AchieveEntity achieve) {
        AchieveUtil.delete(achieve);
    }

}
