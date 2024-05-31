package com.github.abhishekra07.validator;

import com.github.abhishekra07.exception.ColumnValidationException;
import com.github.abhishekra07.mapping.ColumnConfig;
import com.github.abhishekra07.validator.type.DataTypeValidator;
import com.github.abhishekra07.validator.type.impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of the {@link ColumnValidator} interface.
 * <p>
 * This class provides methods to validate column values based on the provided
 * configuration. It utilizes a set of {@link DataTypeValidator} implementations
 * to validate and parse different types of column values.
 * </p>
 */
public class ColumnValidatorImpl implements ColumnValidator {

    /** A mapping of fully qualified type names to their corresponding validators. */
    private static final Map<String, DataTypeValidator> validators = new HashMap<>();

    static {
        validators.put(String.class.getName(), new StringValidator());
        validators.put(Integer.class.getName(), new IntegerValidator());
        validators.put(Boolean.class.getName(), new BooleanValidator());
        validators.put(Double.class.getName(), new DoubleValidator());
        validators.put(Short.class.getName(), new ShortValidator());
        validators.put(Byte.class.getName(), new ShortValidator());
    }

    /**
     * Validates the given value for a column according to the provided column configuration.
     * <p>
     * This method throws a {@link ColumnValidationException} if the value is not valid.
     * </p>
     *
     * @param columnName the name of the column to validate
     * @param columnConfig the configuration of the column, which includes the rules and constraints for validation
     * @param columnValue the value to validate
     * @throws ColumnValidationException if the value is invalid according to the column configuration
     */
    @Override
    public void validate(String columnName, ColumnConfig columnConfig, Object columnValue) {
        if (columnConfig.isRequired() && columnValue == null) {
            throw new ColumnValidationException("Column '" + columnName + "' is required but the value is null.");
        }

        if (columnValue == null) {
            return;
        }

        DataTypeValidator validator = validators.get(columnConfig.getType());
        if (validator == null) {
            throw new IllegalArgumentException("Unsupported type: " + columnConfig.getType());
        }

        try {
            Object validatedValue = validator.validateAndParse(columnValue);
        } catch (ColumnValidationException e) {
            throw new ColumnValidationException("Validation failed for column '" + columnName + "': " + e.getMessage());
        }
    }
}
