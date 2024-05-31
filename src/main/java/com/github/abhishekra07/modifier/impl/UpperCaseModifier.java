package com.github.abhishekra07.modifier.impl;

import com.github.abhishekra07.modifier.ModifierLabel;
import com.github.abhishekra07.modifier.ValueModifier;

/**
 * The {@code UpperCaseModifier} class is an implementation of the {@link ValueModifier} interface
 * that converts a string to uppercase.
 *
 * @param <T> the type of the value to be modified (must be a string)
 */
@ModifierLabel(value = "UpperCaseModifier")
public class UpperCaseModifier implements ValueModifier<String> {

    /**
     * Modifies the given value by converting it to uppercase.
     *
     * @param value the value to be modified
     * @return the modified value with all characters converted to uppercase
     * @throws IllegalArgumentException if the value is null or not of type String
     */
    @Override
    public String modifyValue(String value) {
        if (!ValueModifier.isParamNullOrEmpty(value)) {
            return value.toUpperCase();
        } else {
            throw new IllegalArgumentException("Expected a non-null String value");
        }
    }
}
