package com.nt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MVC_Controller {
	
	@RequestMapping("/showForm")
    public String showForm()
    {
        return "welcome";
    }
	
	@RequestMapping(value="/processForm", params ="action1",method=RequestMethod.POST)
    public String action1()
    {
        System.out.println("Action1 block called");
        return "h1";
    }
    @RequestMapping(value="/processForm",params="action2",method=RequestMethod.POST)
    public String action2()
    {
        System.out.println("Action2 block called");
        return "h2";
    }

}
