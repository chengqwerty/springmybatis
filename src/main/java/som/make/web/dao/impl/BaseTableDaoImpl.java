package som.make.web.dao.impl;

import oracle.jdbc.OracleTypes;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import som.make.web.dao.BaseTableDao;
import som.make.web.entity.Test;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Think on 2017/7/4.
 */

@Repository
public class BaseTableDaoImpl extends SqlSessionDaoSupport implements BaseTableDao {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public void simpleQuery(){
        List<Integer> result=getSqlSession().selectList("som.make.web.mapping.sqllistMapper.findId",4);
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

    @Override
    @Transactional
    public void simpleProcedure(){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", 4);
        params.put("idlist", OracleTypes.CURSOR);
        List<Integer> result=getSqlSession().selectList("som.make.web.mapping.sqllistMapper.simpleProcedure",params);
        for(Test test:(List<Test>)params.get("idlist")){
            System.out.println(test);
        }
        for(Integer i:result){
            System.out.println("====="+i);
        }
    }

    @PostConstruct
    public void injectSessionFactory(){
        super.setSqlSessionFactory(sqlSessionFactory);
    }
}
