package com.trilogyed.collegecostcalculationservice.feign.util;

import com.trilogyed.collegecostcalculationservice.model.Tuition;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "tuition-service")

public interface TuitionService {

    @RequestMapping(name = "/tuition/{major}", method = RequestMethod.GET)
    public Tuition getTuition(@PathVariable String major,
                              @RequestParam(defaultValue = "true") boolean inState,
                              @RequestParam(defaultValue = "true") boolean undergraduate);


    @RequestMapping(name = "/majors", method = RequestMethod.GET)
    public List<String> getAllMajors();
}
