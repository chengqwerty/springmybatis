package som.make.web.controller;

import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import som.make.common.utils.UserUtils;
import som.make.web.entity.Test;
import som.make.common.config.CommonConfig;
import som.make.common.utils.SpringContextHolder;
import som.make.web.service.BaseService;
import som.make.web.service.TestService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Think on 2017/7/3.
 */
@Controller
@RequestMapping("/base")
public class BaseController {
    @Autowired
    public BaseService baseService;

    @Autowired
    public CacheManager cacheManager;

    @RequestMapping()
    public String base(){
        return "redirect:/botany/login.html";
    }

    @RequiresPermissions("base:query")
    @RequestMapping("/query")
    @ResponseBody
    public Map<String, String> simpleQuery(){
        Map<String, String> map = new HashMap<>();
        map.put("message", "shiro permission");
        return map;
    }

    @RequestMapping("/insert")
    public String simpleInsert(){
        Cache cache = cacheManager.getCache(UserUtils.AUTHORIZACACHENAME, String.class, SimpleAuthorizationInfo.class);
        cache.put("2dfdfdfds", new SimpleAuthorizationInfo());
        System.out.println(cache.get("2dfdfdfds"));
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
