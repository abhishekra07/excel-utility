package com.github.abhishekra07.modifier.impl;

import com.github.abhishekra07.modifier.ModifierLabel;
import com.github.abhishekra07.modifier.ValueModifier;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

/**
 * The {@code EncryptionModifier} class is an implementation of the {@link ValueModifier} interface
 * that encrypts sensitive data values using a symmetric encryption algorithm.
 * <p>
 * This class provides a basic implementation of encryption and should be used for educational purposes
 * or as a starting point. In a production environment, you should use industry-standard encryption
 * libraries and practices to ensure data security.
 */
@ModifierLabel(value = "EncryptionModifier")
public class EncryptionModifier implements ValueModifier<String> {

    // Change this key to a secure key in a real-world scenario
    private static final String SECRET_KEY = "MySecretKey123456";

    /**
     * Encrypts the given sensitive data value using the AES encryption algorithm.
     *
     * @param value the sensitive data value to be encrypted
     * @return the encrypted data value as a Base64-encoded string
     */
    @Override
    public String modifyValue(String value) {
        try {
            if (value != null && !value.isEmpty()) {
                Key secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                byte[] encryptedBytes = cipher.doFinal(value.getBytes());
                return Base64.getEncoder().encodeToString(encryptedBytes);
            } else {
                return value; // Return null or empty string as is
            }
        } catch (Exception e) {
            // Handle encryption errors
            e.printStackTrace();
            return value; // Return original value on error
        }
    }
}