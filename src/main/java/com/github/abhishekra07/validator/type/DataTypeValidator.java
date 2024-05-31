package com.github.abhishekra07.validator.type;

import com.github.abhishekra07.exception.ColumnValidationException;

/**
 * Interface for validating and parsing data types.
 * <p>
 * Implementations of this interface are responsible for validating and parsing
 * values of specific data types. The {@code validateAndParse} method should
 * perform validation checks on the provided value and return the parsed value
 * if it is valid.
 * </p>
 */
public interface DataTypeValidator {

    /**
     * Validates and parses the provided column value.
     * <p>
     * This method should validate the provided column value and return the parsed
     * value if it is valid. If the value is not valid, it should throw a
     * {@link ColumnValidationException} with an appropriate error message.
     * </p>
     *
     * @param columnValue the value of the column to validate and parse
     * @return the parsed value if validation is successful
     * @throws ColumnValidationException if the value is invalid
     */
    Object validateAndParse(Object columnValue) throws ColumnValidationException;
}
