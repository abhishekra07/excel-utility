package com.github.abhishekra07.modifier.impl;

import com.github.abhishekra07.modifier.ModifierLabel;
import com.github.abhishekra07.modifier.ValueModifier;

/**
 * The {@code LowerCaseModifier} class is an implementation of the {@link ValueModifier} interface
 * that converts string values to lowercase.
 * <p>
 * This modifier is useful for scenarios where string values need to be converted to lowercase
 * for standardization or comparison purposes.
 * <p>
 * Example usage:
 * <pre>{@code
 * LowerCaseModifier lowerCaseModifier = new LowerCaseModifier();
 * String inputValue = "Hello World";
 * String lowerCaseValue = lowerCaseModifier.modifyValue(inputValue);
 * System.out.println(lowerCaseValue); // Output: "hello world"
 * }</pre>
 */
@ModifierLabel(value = "LowerCaseModifier")
public class LowerCaseModifier implements ValueModifier<String> {

    /**
     * Converts the given string value to lowercase.
     *
     * @param value the string value to be converted
     * @return the string value converted to lowercase, or null if the input value is null
     */
    @Override
    public String modifyValue(String value) {
        if (value != null) {
            return value.toLowerCase();
        } else {
            return null;
        }
    }
}