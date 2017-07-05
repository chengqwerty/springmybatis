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
    private BaseTableDao baseTable;

    @Override
    public void sqlQuery(){
        baseTable.simpleQuery();
    }

    @Override
    public void sqlInsert(){
        baseTable.simpleInsert();
    }

}
