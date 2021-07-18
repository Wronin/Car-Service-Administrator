package com.senla.autoservice.composition.annotations.configurations;

import com.senla.autoservice.composition.ApplicationContext;

import java.io.IOException;

public interface ObjectConfigurator {
    void configure(Object t, ApplicationContext context) throws ReflectiveOperationException, IOException;
}
