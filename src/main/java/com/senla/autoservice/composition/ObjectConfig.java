package com.senla.autoservice.composition;

import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

public class ObjectConfig implements IConfig {

    private Reflections scanner;
    private Map<Class, Class> intrfceToImplClass;

    public ObjectConfig(String packageToScan, Map<Class, Class> intrfceToImplClass) {
        this.intrfceToImplClass = intrfceToImplClass;
        this.scanner = new Reflections("com.senla.autoservice");
    } 

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> intrfce) {
        return intrfceToImplClass.computeIfAbsent(intrfce, aClass -> {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(intrfce);
            if (classes.size() != 1) {
                throw new RuntimeException(intrfce + " has 0 or more than one impl");
            }
            return classes.iterator().next();
        });

    }

    @Override
    public Reflections getScanner() {
        return scanner;
    }
}
