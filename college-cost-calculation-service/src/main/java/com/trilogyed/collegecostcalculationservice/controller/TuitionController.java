package com.trilogyed.collegecostcalculationservice.controller;

import com.trilogyed.collegecostcalculationservice.service.TuitionServiceLayer;
import com.trilogyed.collegecostcalculationservice.viewmodel.TuitionViewModel;
import feign.QueryMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
public class TuitionController {
    @Autowired
    TuitionServiceLayer serviceLayer;

    @RequestMapping(name = "cost/{studentId}/{major}?inState=[true|false]&undergraduate=[true|false]", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public TuitionViewModel getTuition(@PathVariable String studentId, @PathVariable String major, @QueryMap boolean inState, @QueryMap boolean undergraduate){
        TuitionViewModel viewModel = new TuitionViewModel();
        viewModel.setStudentId(studentId);
        viewModel.setMajor(major);
        viewModel.setInState(inState);
        viewModel.setUnderGraduate(undergraduate);
        return serviceLayer.getTuition(viewModel);
    }
}
