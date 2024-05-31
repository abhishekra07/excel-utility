package com.github.abhishekra07.controller;

import com.github.abhishekra07.mapping.MappingConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/csv-service/api/v1/")
public class CsvController {

    @Autowired
    private MappingConfig mappingConfig;

    @GetMapping(value = "read")
    public String readCsvFile(@RequestParam String filename) {
        return "File Read Success!!";
    }
}
