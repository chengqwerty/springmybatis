package som.make.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import som.make.web.dao.BaseTableDao;
import som.make.web.service.BaseService;

/**
 * Created by Think on 2017/7/4.
 */
@Service
public class BaseServiceImpl implements BaseService {
    @Autowired
    private BaseTableDao baseTableDao;

    @Override
    public void sqlQuery(){
        baseTableDao.simpleQuery();
    }

    @Override
    public void sqlInsert(){
        baseTableDao.simpleInsert();
    }

    @Override
    public void sqlProcedure(){
        baseTableDao.simpleProcedure();
    }
}
