package com.trilogyed.collegecostcalculationservice.service;

import com.trilogyed.collegecostcalculationservice.feign.util.FinAidService;
import com.trilogyed.collegecostcalculationservice.feign.util.TuitionService;
import com.trilogyed.collegecostcalculationservice.model.FinancialAid;
import com.trilogyed.collegecostcalculationservice.model.Tuition;
import com.trilogyed.collegecostcalculationservice.viewmodel.TuitionViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TuitionServiceLayer {
    @Autowired
    FinAidService finAidService;
    @Autowired
    TuitionService tuitionService;

    public TuitionServiceLayer(FinAidService finAidService, TuitionService tuitionService) {
        this.finAidService = finAidService;
        this.tuitionService = tuitionService;
    }

    public TuitionViewModel getTuition(String id, String major, boolean inState, boolean undergraduate){
        //builds the object
        TuitionViewModel tvm = new TuitionViewModel();
        tvm.setStudentId(id);
        tvm.setMajor(major);
        tvm.setInState(inState);
        tvm.setUnderGraduate(undergraduate);
        //get the tuition
        tvm.setTuition(tuitionService.getTuition(major, inState, undergraduate).getTuition());
        //gets the financial aid
        tvm.setFinancialAid(finAidService.getFinancialAidByStudent(id).getAidAmount());

        BigDecimal a =
                tvm.getTuition();
        BigDecimal b =
                tvm.getFinancialAid();
        //calculates the final cost
        tvm.setCost(a.subtract(b));
        return tvm;
        //return buildTvm(tvm);
    }


//    private TuitionViewModel buildTvm(TuitionViewModel tvm){
//        Tuition tuition = tuitionService.getTuition(tvm.getMajor(), tvm.isInState(), tvm.isUnderGraduate());
//        FinancialAid financialAid = finAidService.getFinancialAidByStudent(tvm.getStudentId());
//
//        tvm.setTuition(tuition.getTuition());
//        tvm.setFinancialAid(financialAid.getAidAmount());
//
//        BigDecimal a =
//                tvm.getTuition();
//        BigDecimal b =
//                tvm.getFinancialAid();
//
//        tvm.setCost(a.subtract(b));
//
//        return tvm;
//    }

}
