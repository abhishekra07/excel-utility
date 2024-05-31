package com.github.abhishekra07.validator.type.impl;

import com.github.abhishekra07.exception.ColumnValidationException;
import com.github.abhishekra07.validator.type.DataTypeValidator;

/**
 * Implementation of {@link DataTypeValidator} for validating and parsing Short values.
 */
public class ShortValidator implements DataTypeValidator {

    /**
     * Validates and parses the provided column value as a Short.
     *
     * @param columnValue the value of the column to validate and parse
     * @return the parsed Short value if validation is successful
     * @throws ColumnValidationException if the value cannot be parsed into a Short
     */
    @Override
    public Object validateAndParse(Object columnValue) throws ColumnValidationException {
        try {
            if (columnValue instanceof Short || columnValue instanceof Byte) {
                return columnValue;
            }
            return Short.parseShort(columnValue.toString());
        } catch (NumberFormatException e) {
            throw new ColumnValidationException("Value should be of type Short");
        }
    }
}
