package som.make.web.dao.impl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import som.make.web.dao.BaseTableDao;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Think on 2017/7/4.
 */

@Repository
public class BaseTableDaoImpl extends SqlSessionDaoSupport implements BaseTableDao {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public void simpleQuery(){
        List<Integer> result=getSqlSession().selectList("som.make.web.mapping.sqllistMapper.findId");
        for(int i:result){
            System.out.println("======"+i);
        }
    }

    @Override
    @Transactional
    public void simpleInsert(){
        int result=getSqlSession().insert("som.make.web.mapping.sqllistMapper.addId");
        System.out.println(result);
    }

    @PostConstruct
    public void injectSessionFactory(){
        super.setSqlSessionFactory(sqlSessionFactory);
    }
}
