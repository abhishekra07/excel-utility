package com.github.abhishekra07.config;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ValidationException;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

@Component
@ConditionalOnProperty(prefix = "spring", name = "csv", havingValue = "read")
public class YamlLoader {

    private static final Logger logger = LoggerFactory.getLogger(YamlLoader.class);

    @Autowired
    private ValidatorFactory factory;

    private final YAMLMapper yamlMapper = new YAMLMapper();

    public <T> T loadProperties(InputStream inputStream, Class<T> clazz) {
        try {
            return validate(yamlMapper.readValue(inputStream, clazz), clazz);
        } catch (IOException exception) {
            logger.error("Error on configuration reading", exception);
            throw new BeanInitializationException("Essential property bean is not read for type " + clazz.getCanonicalName());
        }
    }

    private <T> T validate(T instance, Class<T> clazz) {
        final Validator validator = factory.getValidator();
        final Set<ConstraintViolation<T>> errors = validator.validate(instance);
        if (!errors.isEmpty()) {
            for (ConstraintViolation<T> violation : errors) {
                logger.error("Validation error for instance of class {}: {}", clazz, violation);
            }
            throw new ValidationException(errors.iterator().next().toString());
        }
        return instance;
    }

}