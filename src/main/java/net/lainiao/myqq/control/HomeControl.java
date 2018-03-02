package net.lainiao.myqq.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeControl {
    @RequestMapping("/")
    public String main(Model model){
        model.addAttribute("mess","这个是第一个页面");
        return "home/main";
    }

    @RequestMapping("/home/index")
    public String index(Model model){
        return "home/index";
    }
}
