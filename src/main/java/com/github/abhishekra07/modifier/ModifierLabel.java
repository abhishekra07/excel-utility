package com.github.abhishekra07.modifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The {@code ModifierLabel} annotation is used to annotate classes
 * that implement the {@link ValueModifier} interface. It provides a mechanism
 * to specify a value for identifying the modifier.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ModifierLabel {

    /**
     * Specifies the identifier value for the modifier. Default value is "DefaultModifier".
     *
     * @return the identifier value for the modifier
     */
    String value() default "DefaultModifier";
}
