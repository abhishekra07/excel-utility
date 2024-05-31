package com.github.abhishekra07.config;

import com.github.abhishekra07.mapping.MappingConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

@Configuration
@ConditionalOnProperty(prefix = "spring", name = "csv", havingValue = "read")
public class CsvConfig {

    @Autowired
    private YamlLoader yamlLoader;

    @Value("${mapping.config.folder:#{null}}")
    private String mappingConfigFolder = "classpath:mapping";

    @Value("${mapping.config.file:#{null}}")
    private String mappingConfigFileName;

    private static final String SEPARATOR = "/";

    @Bean
    public MappingConfig mappingConfig() throws IOException {
        if (mappingConfigFolder != null && mappingConfigFileName != null) {
            Resource resource = pathMatchingResourcePatternResolver().getResource(
                    mappingConfigFolder + SEPARATOR + mappingConfigFileName);
            return yamlLoader.loadProperties(resource.getInputStream(), MappingConfig.class);
        }
        return new MappingConfig();
    }

    @Bean
    public PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver() {
        return new PathMatchingResourcePatternResolver();
    }

}