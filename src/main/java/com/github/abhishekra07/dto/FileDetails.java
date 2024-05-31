package com.github.abhishekra07.dto;

public class FileDetails {
    private String mappingName;
    private String filePath;

    public FileDetails(String mappingName, String filePath) {
        this.mappingName = mappingName;
        this.filePath = filePath;
    }

    public String getMappingName() {
        return mappingName;
    }

    public void setMappingName(String mappingName) {
        this.mappingName = mappingName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
