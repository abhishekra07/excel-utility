package com.github.abhishekra07.modifier.impl;

import com.github.abhishekra07.modifier.ModifierLabel;
import com.github.abhishekra07.modifier.ValueModifier;

/**
 * The {@code MaskingModifier} class is an implementation of the {@link ValueModifier} interface
 * that masks sensitive data values, such as passwords, card numbers, or other confidential information,
 * by replacing all characters between the first and last characters with asterisks ('*').
 *
 * <p>For example, when masking a password:
 * <pre>{@code
 * MaskingModifier maskingModifier = new MaskingModifier();
 * String password = "mysecretpassword";
 * String maskedPassword = maskingModifier.modifyValue(password);
 * System.out.println(maskedPassword); // Output: m***********d
 * }</pre>
 *
 * <p>Similarly, when masking a credit card number:
 * <pre>{@code
 * MaskingModifier maskingModifier = new MaskingModifier();
 * String cardNumber = "1234 5678 9012 3456";
 * String maskedCardNumber = maskingModifier.modifyValue(cardNumber);
 * System.out.println(maskedCardNumber); // Output: 1*************6
 * }</pre>
 */
@ModifierLabel(value = "MaskingModifier")
public class MaskingModifier implements ValueModifier<String> {

    private static final char MASK_CHARACTER = '*'; // Character used for masking

    /**
     * Masks the given sensitive data value by replacing all characters between the first and last
     * characters with asterisks ('*').
     *
     * @param value the sensitive data value to be masked
     * @return the masked data value with characters replaced by asterisks
     */
    @Override
    public String modifyValue(String value) {
        if (value != null && !value.isEmpty()) {
            int length = value.length();
            StringBuilder maskedValue = new StringBuilder(length);
            maskedValue.append(value.charAt(0)); // Append the first character
            maskedValue.append(String.valueOf(MASK_CHARACTER).repeat(Math.max(0, length - 2))); // Mask middle characters
            if (length > 1) {
                maskedValue.append(value.charAt(length - 1));
            }
            return maskedValue.toString();
        } else {
            return value;
        }
    }
}
