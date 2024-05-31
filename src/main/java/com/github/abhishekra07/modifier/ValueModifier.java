package com.github.abhishekra07.modifier;

import java.util.Objects;

/**
 * The {@code ValueModifier} interface provides a contract for classes
 * that modify values of a generic type {@code T}.
 *
 * @param <T> the type of the value to be modified
 */
public interface ValueModifier<T> {

    /**
     * Modifies the given value of type {@code T}.
     *
     * @param value the value to be modified
     * @return the modified value
     */
    T modifyValue(T value);

    /**
     * Checks if the specified parameter is null or empty.
     *
     * @param param the parameter to be checked
     * @return {@code true} if the parameter is null or empty, otherwise {@code false}
     */
    static boolean isParamNullOrEmpty(final Object param) {
        return Objects.isNull(param) || param.toString().isEmpty();
    }
}