package som.make.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/jsajax")
public class JsajaxController {

    @RequestMapping(value = "easy")
    public void easy(@RequestParam String fname,
                     @RequestParam String lname) {
        System.out.println(fname);
        System.out.println(lname);
    }
}
