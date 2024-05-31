package com.github.abhishekra07.validator.type.impl;

import com.github.abhishekra07.exception.ColumnValidationException;
import com.github.abhishekra07.validator.type.DataTypeValidator;

/**
 * Implementation of {@link DataTypeValidator} for validating and parsing Boolean values.
 */
public class BooleanValidator implements DataTypeValidator {

    /**
     * Validates and parses the provided column value as a Boolean.
     *
     * @param columnValue the value of the column to validate and parse
     * @return the parsed Boolean value if validation is successful
     * @throws ColumnValidationException if the value cannot be parsed into a Boolean
     */
    @Override
    public Object validateAndParse(Object columnValue) throws ColumnValidationException {
        if (columnValue instanceof Boolean) {
            return columnValue;
        }
        return Boolean.parseBoolean(columnValue.toString());
    }
}