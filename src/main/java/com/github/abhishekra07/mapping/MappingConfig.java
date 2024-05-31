package com.github.abhishekra07.mapping;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "mappings")
public class MappingConfig  {
    private Map<String, MappingDetails> mappings;

    public Map<String, MappingDetails> getMappings() {
        return mappings;
    }

    public void setMappings(Map<String, MappingDetails> mappings) {
        this.mappings = mappings;
    }
}
