package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by PatrykGrudnik on 12.03.2017.
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/")
    public String index(){

        return "index";
    }
}
