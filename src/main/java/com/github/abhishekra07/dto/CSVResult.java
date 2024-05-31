package com.github.abhishekra07.dto;

import java.util.List;

public class CSVResult<T> {
    private String csvReadStatus;
    private List<FaultyData<T>> faultyDataList;

    public CSVResult(String csvReadStatus, List<FaultyData<T>> faultyDataList) {
        this.csvReadStatus = csvReadStatus;
        this.faultyDataList = faultyDataList;
    }

    public String getCsvReadStatus() {
        return csvReadStatus;
    }

    public void setCsvReadStatus(String csvReadStatus) {
        this.csvReadStatus = csvReadStatus;
    }

    public List<FaultyData<T>> getFaultyDataList() {
        return faultyDataList;
    }

    public void setFaultyDataList(List<FaultyData<T>> faultyDataList) {
        this.faultyDataList = faultyDataList;
    }
}
