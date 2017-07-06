package som.make.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import som.make.web.service.BaseService;
import som.make.web.service.TestService;

/**
 * Created by Think on 2017/7/3.
 */
@Controller
@RequestMapping("/simple")
public class BaseController {
    @Autowired
    public BaseService baseService;

    @RequestMapping("/query")
    public String simpleQuery(){
        baseService.sqlQuery();
        return "index";
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
}
