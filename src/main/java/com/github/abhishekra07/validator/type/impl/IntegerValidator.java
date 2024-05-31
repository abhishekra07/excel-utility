package com.github.abhishekra07.validator.type.impl;

import com.github.abhishekra07.exception.ColumnValidationException;
import com.github.abhishekra07.validator.type.DataTypeValidator;

/**
 * Implementation of {@link DataTypeValidator} for validating and parsing Integer values.
 */
public class IntegerValidator implements DataTypeValidator {

    /**
     * Validates and parses the provided column value as an Integer.
     *
     * @param columnValue the value of the column to validate and parse
     * @return the parsed Integer value if validation is successful
     * @throws ColumnValidationException if the value cannot be parsed into an Integer
     */
    @Override
    public Object validateAndParse(Object columnValue) throws ColumnValidationException {
        try {
            if (columnValue instanceof Integer) {
                return columnValue;
            }
            return Integer.parseInt(columnValue.toString());
        } catch (NumberFormatException e) {
            throw new ColumnValidationException("Value should be of type Integer");
        }
    }
}