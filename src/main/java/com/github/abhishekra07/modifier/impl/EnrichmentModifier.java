package com.github.abhishekra07.modifier.impl;

import com.github.abhishekra07.modifier.ValueModifier;

/**
 * The {@code EnrichmentModifier} class is an implementation of the {@link ValueModifier} interface
 * that enriches string values by appending a suffix.
 * <p>
 * This modifier is useful for scenarios where string values need to be enriched or augmented
 * with additional information for processing or identification purposes.
 * <p>
 * Example usage:
 * <pre>{@code
 * EnrichmentModifier enrichmentModifier = new EnrichmentModifier();
 * String inputValue = "Data";
 * String enrichedValue = enrichmentModifier.modifyValue(inputValue);
 * System.out.println(enrichedValue); // Output: "Data_enriched"
 * }</pre>
 */
public class EnrichmentModifier implements ValueModifier<String> {

    private static final String SUFFIX = "_enriched";

    /**
     * Appends the predefined suffix to the given string value.
     *
     * @param value the string value to be enriched
     * @return the enriched string value with the predefined suffix appended, or null if the input value is null
     */
    @Override
    public String modifyValue(String value) {
        if (value != null) {
            return value + SUFFIX;
        } else {
            return null; // Return null for null values
        }
    }

}