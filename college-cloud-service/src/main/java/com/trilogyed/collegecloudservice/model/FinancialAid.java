package com.trilogyed.collegecloudservice.model;

import java.math.BigDecimal;

public class FinancialAid {

    private String studentId;
    private BigDecimal aidAmount;
    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public BigDecimal getAidAmount() {
        return aidAmount;
    }
    public void setAidAmount(BigDecimal aidAmount) {
        this.aidAmount = aidAmount;
    }

}
