package com.github.abhishekra07.modifier.impl;

import com.github.abhishekra07.modifier.ValueModifier;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class DecryptionModifier implements ValueModifier<String> {

    // Change this key to match the encryption key used
    private static final String SECRET_KEY = "MySecretKey123456";

    @Override
    public String modifyValue(String value) {
        try {
            if (value != null && !value.isEmpty()) {
                Key secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
                byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(value));
                return new String(decryptedBytes);
            } else {
                return value; // Return null or empty string as is
            }
        } catch (Exception e) {
            // Handle decryption errors
            e.printStackTrace();
            return value; // Return original value on error
        }
    }
}
