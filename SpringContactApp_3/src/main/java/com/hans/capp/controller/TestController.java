package com.hans.capp.controller;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Vikram
 */
@Controller
public class TestController {
    @RequestMapping("/test/hello")
    public String helloWorld(){
        return "hello"; // -> /WEB-INF/view/hello.jsp
    }
    
}
