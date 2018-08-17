package com.cts.devops.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The type Index controller.
 */
@Controller
public class IndexController {
    /**
     * Index string.
     *
     * @return the string
     */
    @RequestMapping("/")
    String index(){
        return "index";
    }
}
