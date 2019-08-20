package com.trilogyed.collegecostcalculationservice.feign.util;

import com.trilogyed.collegecostcalculationservice.model.FinancialAid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "finaid-service")
@RequestMapping(value = "/students")
public interface FinAidService {

    @GetMapping
    public List<FinancialAid> getAllFinancialAid();

    @GetMapping(value = "/{id}")
    public FinancialAid getFinancialAidByStudent(@PathVariable String id);

}
