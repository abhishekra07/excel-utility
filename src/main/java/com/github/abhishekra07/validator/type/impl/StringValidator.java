package com.github.abhishekra07.validator.type.impl;

import com.github.abhishekra07.exception.ColumnValidationException;
import com.github.abhishekra07.validator.type.DataTypeValidator;

/**
 * Implementation of {@link DataTypeValidator} for validating and parsing String values.
 */
public class StringValidator implements DataTypeValidator {

    /**
     * Validates and parses the provided column value as a String.
     *
     * @param columnValue the value of the column to validate and parse
     * @return the parsed String value if validation is successful
     * @throws ColumnValidationException if the value cannot be parsed into a String
     */
    @Override
    public Object validateAndParse(Object columnValue) throws ColumnValidationException {
        if (columnValue instanceof String) {
            return columnValue;
        }
        return columnValue.toString();
    }
}