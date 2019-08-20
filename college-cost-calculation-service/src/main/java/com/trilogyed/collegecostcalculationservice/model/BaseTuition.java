package com.trilogyed.collegecostcalculationservice.model;

import java.math.BigDecimal;
import java.util.Objects;

public class BaseTuition {
    private String major;
    private BigDecimal tuition;
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public BigDecimal getTuition() {
        return tuition;
    }
    public void setTuition(BigDecimal tuition) {
        this.tuition = tuition;
    }
}
