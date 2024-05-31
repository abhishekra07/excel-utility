package com.github.abhishekra07.modifier.impl;

import com.github.abhishekra07.modifier.ModifierLabel;
import com.github.abhishekra07.modifier.ValueModifier;
import org.springframework.stereotype.Component;

/**
 * The {@code DateFormatModifier} class is an implementation of the {@link ValueModifier} interface
 * that converts date values to a specific date format.
 * <p>
 * This modifier is useful for scenarios where date values need to be converted to a standardized date format.
 * <p>
 * Example usage:
 * <pre>{@code
 * DateFormatModifier dateFormatModifier = new DateFormatModifier();
 * String dateValue = "2024-05-30";
 * String formattedDate = dateFormatModifier.modifyValue(dateValue);
 * System.out.println(formattedDate); // Output: "30th May 2024"
 * }</pre>
 */
@ModifierLabel(value = "DateFormatModifier")
@Component
public class DateFormatModifier implements ValueModifier<String> {

    private static final String ORIGINAL_DATE_FORMAT = "yyyy-MM-dd";
    private static final String TARGET_DATE_FORMAT = "dd MMMM yyyy";

    /**
     * Converts the given date value to the specified date format.
     *
     * @param value the date value to be converted
     * @return the date value converted to the specified date format
     */
    @Override
    public String modifyValue(String value) {
        if (value != null) {
            try {
                // Parse the original date format
                java.text.SimpleDateFormat originalFormat = new java.text.SimpleDateFormat(ORIGINAL_DATE_FORMAT);
                java.util.Date date = originalFormat.parse(value);

                // Format the date to the target date format
                java.text.SimpleDateFormat targetFormat = new java.text.SimpleDateFormat(TARGET_DATE_FORMAT);
                return targetFormat.format(date);
            } catch (java.text.ParseException e) {
                // Handle parsing errors
                e.printStackTrace();
                return value; // Return original value on error
            }
        } else {
            return null; // Return null for null values
        }
    }
}