package com.trilogyed.collegecostcalculationservice.service;

import com.trilogyed.collegecostcalculationservice.feign.util.FinAidService;
import com.trilogyed.collegecostcalculationservice.feign.util.TuitionService;
import com.trilogyed.collegecostcalculationservice.model.BaseTuition;
import com.trilogyed.collegecostcalculationservice.model.FinancialAid;
import com.trilogyed.collegecostcalculationservice.model.Tuition;
import com.trilogyed.collegecostcalculationservice.viewmodel.TuitionViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TuitionServiceLayerTest {
    FinAidService finAidService;
    TuitionService tuitionService;
    TuitionServiceLayer service;

    @Before
    public void setUp() {
        finAidService = mock(FinAidService.class);
        tuitionService = mock(TuitionService.class);
        buildMock();

        service = new TuitionServiceLayer(finAidService, tuitionService);
    }

    @Test
    public void getCost(){
        TuitionViewModel tuition = new TuitionViewModel();
        tuition.setInState(false);
        tuition.setMajor("BS");
        tuition.setUnderGraduate(false);
        tuition.setStudentId("12");

        TuitionViewModel tuitionViewModel = service.getTuition(tuition);
        assertEquals(tuition, tuitionViewModel);
    }

    private void buildMock(){
        BaseTuition baseTuition = new BaseTuition();
        baseTuition.setTuition(BigDecimal.valueOf(500.00));
        baseTuition.setMajor("BS");

        FinancialAid financialAid = new FinancialAid();
        financialAid.setAidAmount(BigDecimal.valueOf(200.00));
        financialAid.setStudentId("12");

        Tuition tuition = new Tuition();
        tuition.setInState(false);
        tuition.setMajor("BS");
        tuition.setUndergraduate(false);
        BigDecimal a = baseTuition.getTuition();
        BigDecimal b = financialAid.getAidAmount();
        tuition.setTuition(a.subtract(b));

        doReturn(tuition).when(tuitionService).getTuition("BS", false, false);
        doReturn(financialAid).when(finAidService).getFinancialAidByStudent("12");
    }
}
