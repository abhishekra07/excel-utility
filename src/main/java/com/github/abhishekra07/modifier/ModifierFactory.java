package com.github.abhishekra07.modifier;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Factory class for managing and retrieving ValueModifiers.
 */
@Component
public class ModifierFactory {

    @Autowired
    private List<ValueModifier> valueModifiers;

    private Map<String, ValueModifier> valueModifierRegistryMap;

    /**
     * Retrieves a ValueModifier by its name.
     *
     * @param modifierName the name of the ValueModifier to retrieve
     * @return the ValueModifier corresponding to the given name
     * @throws IllegalArgumentException if no ValueModifier is registered with the given name
     */
    public ValueModifier getValueModifierByName(String modifierName) {
        ValueModifier valueModifier = valueModifierRegistryMap.get(modifierName);
        if (Objects.isNull(valueModifier)) {
            throw new IllegalArgumentException("No Value Modifier Registered for name " + modifierName);
        }
        return valueModifier;
    }

    /**
     * Initializes the registry of ValueModifiers.
     * <p>
     * This method is called after the bean has been constructed and dependencies have been injected.
     * It populates the valueModifierRegistryMap with ValueModifiers obtained from valueModifiers list.
     * </p>
     */
    @PostConstruct
    public void initializeRegistry() {
        if (!CollectionUtils.isEmpty(valueModifiers)) {
            valueModifiers.forEach(valueModifier -> {
                ModifierLabel modifier = valueModifier.getClass().getAnnotation(ModifierLabel.class);
                valueModifierRegistryMap.put(modifier.value(), valueModifier);
            });
        }
    }
}