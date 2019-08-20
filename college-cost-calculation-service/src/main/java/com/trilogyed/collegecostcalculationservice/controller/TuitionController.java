package com.trilogyed.collegecostcalculationservice.controller;

import com.trilogyed.collegecostcalculationservice.viewmodel.TuitionViewModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TuitionController {
    @RequestMapping(name = "cost/{studentId}/{major}?inState=[true|false]&undergraduate=[true|false]", method = RequestMethod.GET)
    public TuitionViewModel getTuition(){
        return null;
    }
}
