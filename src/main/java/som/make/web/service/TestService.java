package som.make.web.service;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by Think on 2017/7/3.
 */
@Service
public class TestService extends SqlSessionDaoSupport {
    @Resource
    private SqlSessionFactory sqlSessionFactory;

    public void sqlTest(){
        int result = getSqlSession().selectOne("som.make.web.mapping.sqllistMapper.query_failurerate");
        System.out.println(result);
    }

    @Transactional(propagation= Propagation.REQUIRED)
    public void addId(){
        int result = getSqlSession().insert("som.make.web.mapping.sqllistMapper.addId",2);
        System.out.println("addId result is "+result);
    }

    @PostConstruct
    public void injectSessionFactory(){
        super.setSqlSessionFactory(sqlSessionFactory);
    }
}
