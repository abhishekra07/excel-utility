package com.github.abhishekra07.modifier.impl;

import com.github.abhishekra07.modifier.ModifierLabel;
import com.github.abhishekra07.modifier.ValueModifier;

/**
 * The {@code TrimModifier} class is an implementation of the {@link ValueModifier} interface
 * that trims leading and trailing whitespaces from string values.
 * <p>
 * This modifier is useful for scenarios where string values may contain leading or trailing whitespaces
 * that need to be removed for standardization or comparison purposes.
 * <p>
 * Example usage:
 * <pre>{@code
 * TrimModifier trimModifier = new TrimModifier();
 * String inputValue = "  Trimmed Value  ";
 * String trimmedValue = trimModifier.modifyValue(inputValue);
 * System.out.println(trimmedValue); // Output: "Trimmed Value"
 * }</pre>
 */
@ModifierLabel(value = "TrimModifier")
public class TrimModifier implements ValueModifier<String> {

    /**
     * Trims leading and trailing whitespaces from the given string value.
     *
     * @param value the string value to be trimmed
     * @return the string value with leading and trailing whitespaces removed, or null if the input value is null
     */
    @Override
    public String modifyValue(String value) {
        if (value != null) {
            return value.trim();
        } else {
            return null; // Return null for null values
        }
    }
}