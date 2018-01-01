package som.make.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import som.make.common.utils.SysShiroUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "${cactiPath}")
public class LoginController {

    @Value("${cactiPath}")
    protected String cactiPath;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String algaLogin(HttpServletRequest request, HttpServletResponse response) {
        Subject subject = SecurityUtils.getSubject();
        Object principal = subject.getPrincipal();
        if (principal != null) {
            return "redirect:/botany/botanyApp.html";
        }
        return "redirect:/botany/login.html";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String failAlgaLogin() {
        String principal = SysShiroUtils.getPrincipal();
        if (principal != null) {
            return "redirect:/botany/botanyApp.html";
        }
        return "redirect:/botany/login.html";
    }

    @RequestMapping(value = "loginSuccess")
    public String loginSuccess() {
        return "redirect:/botany/botanyApp.html";
    }
}
