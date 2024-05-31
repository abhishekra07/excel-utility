package com.github.abhishekra07.validator;

import com.github.abhishekra07.mapping.ColumnConfig;

/**
 * Interface for validating columns in a dataset.
 * <p>
 * Implementations of this interface are responsible for validating
 * data values based on the provided configuration of the column.
 * </p>
 *
 * @since 1.0
 */
public interface ColumnValidator {

    /**
     * Validates the given value for a column according to the provided column configuration.
     * <p>
     * This method should throw an exception if the value is not valid. The type and
     * message of the exception should provide meaningful information about why the
     * validation failed.
     * </p>
     *
     * @param columnName  the name of the column to validate
     * @param columnConfig  the configuration of the column, which includes the rules and constraints for validation
     * @param value  the value to validate
     * @throws IllegalArgumentException if the value is invalid according to the column configuration
     */
    void validate(String columnName, ColumnConfig columnConfig, Object value);
}
