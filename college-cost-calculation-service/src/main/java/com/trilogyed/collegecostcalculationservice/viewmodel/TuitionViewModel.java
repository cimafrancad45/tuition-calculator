package com.trilogyed.collegecostcalculationservice.viewmodel;

import java.math.BigDecimal;
import java.util.Objects;

public class TuitionViewModel {
    private String studentId;
    private String major;
    private boolean inState;
    private boolean underGraduate;
    private BigDecimal financialAid;
    private BigDecimal tuition;
    private BigDecimal cost;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public boolean isInState() {
        return inState;
    }

    public void setInState(boolean inState) {
        this.inState = inState;
    }

    public boolean isUnderGraduate() {
        return underGraduate;
    }

    public void setUnderGraduate(boolean underGraduate) {
        this.underGraduate = underGraduate;
    }

    public BigDecimal getFinancialAid() {
        return financialAid;
    }

    public void setFinancialAid(BigDecimal financialAid) {
        this.financialAid = financialAid;
    }

    public BigDecimal getTuition() {
        return tuition;
    }

    public void setTuition(BigDecimal tuition) {
        this.tuition = tuition;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TuitionViewModel that = (TuitionViewModel) o;
        return inState == that.inState &&
                underGraduate == that.underGraduate &&
                Objects.equals(studentId, that.studentId) &&
                Objects.equals(major, that.major) &&
                Objects.equals(financialAid, that.financialAid) &&
                Objects.equals(tuition, that.tuition) &&
                Objects.equals(cost, that.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, major, inState, underGraduate, financialAid, tuition, cost);
    }
}
