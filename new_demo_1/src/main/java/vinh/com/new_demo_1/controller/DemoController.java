package vinh.com.new_demo_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
   @GetMapping("/hello")
    public String sayHello(Model theModel)
   {
        theModel.addAttribute("theDAte", new java.util.Date());

        return "helloworld";
   }
}
