package com.trilogyed.collegecostcalculationservice.service;

import com.trilogyed.collegecostcalculationservice.feign.util.FinAidService;
import com.trilogyed.collegecostcalculationservice.feign.util.TuitionService;
import com.trilogyed.collegecostcalculationservice.model.BaseTuition;
import com.trilogyed.collegecostcalculationservice.model.FinancialAid;
import com.trilogyed.collegecostcalculationservice.model.Tuition;
import com.trilogyed.collegecostcalculationservice.viewmodel.TuitionViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TuitionServiceLayerTest {
//    FinAidService finAidService;
//    TuitionService tuitionService;
//    TuitionServiceLayer service;
//
//    @Before
//    public void setUp() {
//        finAidService = mock(FinAidService.class);
//        tuitionService = mock(TuitionService.class);
//        buildMock();
//
//        service = new TuitionServiceLayer(finAidService, tuitionService);
//    }
//
//    @Test
//    public void getCost(){
//        TuitionViewModel tuition = new TuitionViewModel();
//        tuition.setInState(false);
//        tuition.setMajor("BS");
//        tuition.setUnderGraduate(false);
//        tuition.setStudentId("12");
//
//        TuitionViewModel tuitionViewModel = service.getTuition(tuition);
//        assertEquals(tuition, tuitionViewModel);
//    }
//
//    private void buildMock(){
//        BaseTuition baseTuition = new BaseTuition();
//        baseTuition.setTuition(BigDecimal.valueOf(500.00));
//        baseTuition.setMajor("BS");
//
//        FinancialAid financialAid = new FinancialAid();
//        financialAid.setAidAmount(BigDecimal.valueOf(200.00));
//        financialAid.setStudentId("12");
//
//        Tuition tuition = new Tuition();
//        tuition.setInState(false);
//        tuition.setMajor("BS");
//        tuition.setUndergraduate(false);
//        BigDecimal a = baseTuition.getTuition();
//        BigDecimal b = financialAid.getAidAmount();
//        tuition.setTuition(a.subtract(b));
//
//        doReturn(tuition).when(tuitionService).getTuition("BS", false, false);
//        doReturn(financialAid).when(finAidService).getFinancialAidByStudent("12");
//    }
    @Mock
    FinAidService finAidClient;

    @Mock
    TuitionService tuitionClient;

    TuitionServiceLayer service;

    @Before
    public void setUp() {
        service = new TuitionServiceLayer(finAidClient, tuitionClient);
    }

    @Test
    public void calculateCollegeCost() {
        FinancialAid aid = new FinancialAid();
        aid.setStudentId("0001");
        aid.setAidAmount(new BigDecimal("100.00"));

        Tuition tuition  = new Tuition();
        tuition.setMajor("business");
        tuition.setInState(true);
        tuition.setUndergraduate(true);
        tuition.setTuition(new BigDecimal("500.00"));

        TuitionViewModel expectedCost = new TuitionViewModel();
        expectedCost.setStudentId("0001");
        expectedCost.setMajor("business");
        expectedCost.setInState(true);
        expectedCost.setUnderGraduate(true);
        expectedCost.setFinancialAid(new BigDecimal("100.00"));
        expectedCost.setTuition(new BigDecimal("500.00"));
        expectedCost.setCost(new BigDecimal("400.00"));

        Mockito.when(finAidClient.getFinancialAidByStudent("0001")).thenReturn(aid);
        Mockito.when(tuitionClient.getTuition("business", true, true)).thenReturn(tuition);

        TuitionViewModel cost = service.getTuition("0001", "business", true, true);

        assertEquals(expectedCost, cost);
    }
}
