package com.github.abhishekra07.validator.type.impl;

import com.github.abhishekra07.exception.ColumnValidationException;
import com.github.abhishekra07.validator.type.DataTypeValidator;

/**
 * Implementation of {@link DataTypeValidator} for validating and parsing Double values.
 */
public class DoubleValidator implements DataTypeValidator {

    /**
     * Validates and parses the provided column value as a Double.
     *
     * @param columnValue the value of the column to validate and parse
     * @return the parsed Double value if validation is successful
     * @throws ColumnValidationException if the value cannot be parsed into a Double
     */
    @Override
    public Object validateAndParse(Object columnValue) throws ColumnValidationException {
        try {
            if (columnValue instanceof Double) {
                return columnValue;
            }
            return Double.parseDouble(columnValue.toString());
        } catch (NumberFormatException e) {
            throw new ColumnValidationException("Value should be of type Double");
        }
    }
}