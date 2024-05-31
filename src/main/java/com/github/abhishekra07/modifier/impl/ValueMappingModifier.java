package com.github.abhishekra07.modifier.impl;

import com.github.abhishekra07.modifier.ModifierLabel;
import com.github.abhishekra07.modifier.ValueModifier;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code ValueMappingModifier} class is an implementation of the {@link ValueModifier} interface
 * that maps input values to predefined output values based on a mapping table.
 * <p>
 * This modifier is useful for scenarios where certain input values need to be transformed
 * or replaced with predefined output values.
 * <p>
 * Example usage:
 * <pre>{@code
 * ValueMappingModifier mappingModifier = new ValueMappingModifier();
 * String input = "1";
 * String output = mappingModifier.modifyValue(input);
 * System.out.println(output); // Output: "A"
 * }</pre>
 */
@ModifierLabel(value = "ValueMappingModifier")
public class ValueMappingModifier implements ValueModifier<String> {

    private static final Map<String, String> VALUE_MAPPING = new HashMap<>();

    static {
        VALUE_MAPPING.put("1", "A");
        VALUE_MAPPING.put("2", "B");
        VALUE_MAPPING.put("3", "C");
    }

    /**
     * Maps the given input value to a predefined output value based on the mapping table.
     *
     * @param value the input value to be mapped
     * @return the mapped output value, or the original input value if no mapping found
     */
    @Override
    public String modifyValue(String value) {
        if (value != null && VALUE_MAPPING.containsKey(value)) {
            return VALUE_MAPPING.get(value);
        } else {
            return value;
        }
    }
}