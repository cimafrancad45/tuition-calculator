package com.trilogyed.collegecostcalculationservice.service;

import com.trilogyed.collegecostcalculationservice.feign.util.FinAidService;
import com.trilogyed.collegecostcalculationservice.feign.util.TuitionService;
import com.trilogyed.collegecostcalculationservice.model.FinancialAid;
import com.trilogyed.collegecostcalculationservice.model.Tuition;
import com.trilogyed.collegecostcalculationservice.viewmodel.TuitionViewModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class TuitionServiceLayer {
    @Autowired
    FinAidService finAidService;
    @Autowired
    TuitionService tuitionService;

    public TuitionViewModel getTuition(TuitionViewModel tvm){
        return buildTvm(tvm);
    }


    private TuitionViewModel buildTvm(TuitionViewModel tvm){
        Tuition tuition = tuitionService.getTuition(tvm.getMajor(), tvm.isInState(), tvm.isUnderGraduate());
        FinancialAid financialAid = finAidService.getFinancialAidByStudent(tvm.getStudentId());

        tvm.setTuition(tuition.getTuition());
        tvm.setFinancialAid(financialAid.getAidAmount());

        BigDecimal a =
                tvm.getTuition();
        BigDecimal b =
                tvm.getFinancialAid();

        tvm.setCost(a.subtract(b));




        return null;
    }

}
