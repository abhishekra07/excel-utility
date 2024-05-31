package com.github.abhishekra07.mapping;

import java.util.Map;

public class MappingDetails {
    private Map<String, ColumnConfig> columns;

    public Map<String, ColumnConfig> getColumns() {
        return columns;
    }

    public void setColumns(Map<String, ColumnConfig> columns) {
        this.columns = columns;
    }
}