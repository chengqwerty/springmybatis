package som.make.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import som.make.web.entity.Test;
import som.make.common.config.CommonConfig;
import som.make.common.utils.SpringContextHolder;
import som.make.web.service.BaseService;
import som.make.web.service.TestService;

/**
 * Created by Think on 2017/7/3.
 */
@Controller
@RequestMapping("/")
public class BaseController {
    @Autowired
    public BaseService baseService;

    @RequestMapping()
    public String base(){
        return "index.html";
    }

    @RequestMapping("/query")
    public String simpleQuery(Test test){
        System.out.println(test);
        baseService.sqlQuery();
        return "index.html";
    }

    @RequestMapping("/insert")
    public String simpleInsert(){
        baseService.sqlInsert();
        return "index";
    }

    @RequestMapping("/simpleProcedure")
    public String simpleProcedure(){
        baseService.sqlProcedure();
        return "index";
    }

    @RequestMapping("/test")
    public void test() {
        CommonConfig commonConfig = SpringContextHolder.getBean("commonConfig");
        commonConfig.say();
    }
}
