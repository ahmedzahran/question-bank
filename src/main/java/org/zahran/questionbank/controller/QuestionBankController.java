package org.zahran.questionbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuestionBankController {


    @GetMapping("/")
    @ResponseBody
    public String home(){
        return "heelo home";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
