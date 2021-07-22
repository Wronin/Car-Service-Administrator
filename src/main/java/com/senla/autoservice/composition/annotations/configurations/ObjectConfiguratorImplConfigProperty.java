package com.senla.autoservice.composition.annotations.configurations;

import com.senla.autoservice.composition.ApplicationContext;
import com.senla.autoservice.composition.annotations.ConfigProperty;
import java.lang.reflect.Field;


public class ObjectConfiguratorImplConfigProperty implements ObjectConfigurator {

    @Override
    public void configure(Object t, ApplicationContext context) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> implClass = t.getClass();
        for (Field field : implClass.getDeclaredFields()) {
            ConfigProperty annotation = field.getAnnotation(ConfigProperty.class);
            if (annotation != null) {
                field.setAccessible(true);
                Object object = Class.forName(annotation.PropertyName()).newInstance();
                field.set(t, object);
            }
        }
    }


}
