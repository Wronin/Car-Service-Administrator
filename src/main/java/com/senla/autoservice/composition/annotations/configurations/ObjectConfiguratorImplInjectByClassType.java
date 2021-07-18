package com.senla.autoservice.composition.annotations.configurations;

import com.senla.autoservice.composition.ApplicationContext;
import com.senla.autoservice.composition.annotations.InjectByClassType;

import java.lang.reflect.Field;

public class ObjectConfiguratorImplInjectByClassType implements ObjectConfigurator {

    @Override
    public void configure(Object t, ApplicationContext context) throws ReflectiveOperationException {
        for (Field field : t.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectByClassType.class)) {
                field.setAccessible(true);
                Object object = context.getObject(field.getType());
                field.set(t, object);
            }
        }
    }

}
