package com.trilogyed.collegecostcalculationservice.service;


import com.trilogyed.collegecostcalculationservice.feign.util.FinAidService;
import com.trilogyed.collegecostcalculationservice.model.Tuition;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TuitionServiceLayerTest {
    @Autowired
    FinAidService finAid;

    @Autowired
    Tuition tuition;

    @Before
    public void setUp() {

    }

    @Test
    public void something(){}
}
