package com.senla.autoservice.composition;

import org.reflections.Reflections;

public interface IConfig {
    <T> Class<? extends T> getImplClass(Class<T> intrfce);
    Reflections getScanner();
}
