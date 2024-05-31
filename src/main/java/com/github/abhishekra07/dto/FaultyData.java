package com.github.abhishekra07.dto;

import java.io.Serializable;

public class FaultyData<T> implements Serializable {

    private static final long serialVersionUID = -373919707740436550L;
    private long rowNumber;
    private String error;
    private T data;

    public FaultyData(long rowNumber, String error, T data) {
        this.rowNumber = rowNumber;
        this.error = error;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public long getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(long rowNumber) {
        this.rowNumber = rowNumber;
    }
}
