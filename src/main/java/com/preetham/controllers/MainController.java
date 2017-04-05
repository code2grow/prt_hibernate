package com.preetham.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

  @RequestMapping("/")
  @ResponseBody
  public String index() {
    return "Proudly handcrafted by " + 
        "Preetham :-) - seems like the app is up and running.";
  }

}
